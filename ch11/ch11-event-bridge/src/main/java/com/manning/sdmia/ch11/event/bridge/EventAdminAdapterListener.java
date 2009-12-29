package com.manning.sdmia.ch11.event.bridge;

import java.util.Properties;

import org.osgi.framework.Bundle;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.springframework.osgi.context.event.OsgiBundleApplicationContextEvent;
import org.springframework.osgi.context.event.OsgiBundleApplicationContextListener;

public class EventAdminAdapterListener implements OsgiBundleApplicationContextListener<OsgiBundleApplicationContextEvent> {
	private EventAdmin eventAdmin;

	private String buildTopicName(OsgiBundleApplicationContextEvent event) {
		String eventClassName = event.getClass().getName();
		return eventClassName.replace(".", "/");
	}

	private Properties buildEventProperties(OsgiBundleApplicationContextEvent event) {
		Properties eventProperties = new Properties();
		
		eventProperties.put("event.timestamp", event.getTimestamp());
		Object source = event.getSource();
		eventProperties.put("event.source.class", source.getClass().getName());
		
		Bundle bundle = event.getBundle();
		eventProperties.put("event.bundle.id", bundle.getSymbolicName());
		eventProperties.put("event.bundle.state", bundle.getState());
		
		return eventProperties;
	}

	public void onOsgiApplicationEvent(OsgiBundleApplicationContextEvent event) {
		System.out.println("onOsgiApplicationEvent - event = "+event);
		String topicName = buildTopicName(event);
		Properties eventProperties = buildEventProperties(event);
		System.out.println("> sendEvent - topicName = "+topicName);
		eventAdmin.sendEvent(new Event(topicName, eventProperties));
		System.out.println("< sendEvent");
	}

	public EventAdmin getEventAdmin() {
		return eventAdmin;
	}

	public void setEventAdmin(EventAdmin eventAdmin) {
		this.eventAdmin = eventAdmin;
	}

}

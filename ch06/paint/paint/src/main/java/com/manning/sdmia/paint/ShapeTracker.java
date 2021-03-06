/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.manning.sdmia.paint;

import java.util.Map;

import javax.swing.Icon;
import javax.swing.SwingUtilities;

import com.manning.sdmia.paint.shape.SimpleShape;



/**
 * POJO-based service tracker to add/remove shape to/from the window.
 * @author Richard S. Hall
 * @author Arnaud Cogoluegnes
 */
public class ShapeTracker {
	
	// Flag indicating an added shape.
    private static final int ADDED = 1;
    // Flag indicating a removed shape.
    private static final int REMOVED = 2;

	private DrawingFrame drawingFrame;

	public void setDrawingFrame(DrawingFrame drawingFrame) {
		this.drawingFrame = drawingFrame;
	}

	public Object addingShape(SimpleShape shape, Map properties) {
		processShapeOnEventThread(ADDED, properties, shape);
		return shape;
	}
	
	public void removedShape(SimpleShape shape, Map properties) {
		processShapeOnEventThread(REMOVED, properties, shape);
	}

	
	private void processShapeOnEventThread(int action, Map properties,
			SimpleShape shape) {
		try {
			if (SwingUtilities.isEventDispatchThread()) {
				processShape(action, properties, shape);
			} else {
				SwingUtilities.invokeAndWait(new ShapeRunnable(action, properties,
						shape));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Actually performs the processing of the service notification. Invokes the
	 * appropriate callback method on the application object depending on the
	 * action type of the notification.
	 * 
	 * @param action
	 *            The type of action associated with the notification.
	 * @param ref
	 *            The service reference of the corresponding service.
	 * @param shape
	 *            The service object of the corresponding service.
	 **/
	private void processShape(int action, Map properties,
			SimpleShape shape) {
		String name = (String) properties.get(SimpleShape.NAME_PROPERTY);
		switch (action) {
		case ADDED:
			Icon icon = (Icon) properties.get(SimpleShape.ICON_PROPERTY);
			drawingFrame.addShape(name, icon, new DefaultShape(shape)); 
			break;

		case REMOVED:
			drawingFrame.removeShape(name);
			break;
		}
	}

	/**
	 * Simple class used to process service notification handling on the Swing
	 * event thread.
	 **/
	private class ShapeRunnable implements Runnable {
		private int m_action;
		private Map properties;
		private SimpleShape m_shape;

		/**
		 * Constructs an object with the specified action, service reference,
		 * and service object for processing on the Swing event thread.
		 * 
		 * @param action
		 *            The type of action associated with the notification.
		 * @param ref
		 *            The service reference of the corresponding service.
		 * @param shape
		 *            The service object of the corresponding service.
		 **/
		public ShapeRunnable(int action, Map properties, SimpleShape shape) {
			m_action = action;
			this.properties = properties;
			m_shape = shape;
		}

		/**
		 * Calls the <tt>processShape()</tt> method.
		 **/
		public void run() {
			processShape(m_action, properties, m_shape);
		}
	}

}

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

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;

/**
 * Listener that stops the bundle when the window is closed.
 * @author Arnaud Cogoluegnes
 *
 */
public class CloseWindowListener extends WindowAdapter {
	
	private BundleContext bundleContext;

	@Override
	public void windowClosing(WindowEvent e) {
		e.getWindow().dispose();
		// out of the EDT
		Thread t = new Thread() {
			@Override
			public void run() {
				try {
					bundleContext.getBundle().stop();
				} catch (BundleException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
			}
		};
		t.start();		
	}
	
	public void setBundleContext(BundleContext bundleContext) {
		this.bundleContext = bundleContext;
	}
	
}

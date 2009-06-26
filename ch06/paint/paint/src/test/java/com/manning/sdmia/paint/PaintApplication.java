/**
 * 
 */
package com.manning.sdmia.paint;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * @author acogoluegnes
 *
 */
public class PaintApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DrawingFrame frame = new DrawingFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.addShape("dummy", new ImageIcon(PaintApplication.class.getResource("/square.png")), new DummyShape());
		
	}

}

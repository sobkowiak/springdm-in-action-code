/**
 * 
 */
package com.manning.sdmia.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

import com.manning.sdmia.paint.shape.SimpleShape;

/**
 * @author acogoluegnes
 * 
 */
public class DummyShape implements SimpleShape {

	/**
	 * Implements the <tt>SimpleShape.draw()</tt> method for painting the shape.
	 * 
	 * @param g2
	 *            The graphics object used for painting.
	 * @param p
	 *            The position to paint the triangle.
	 **/
	public void draw(Graphics2D g2, Point p) {
		int x = p.x - 25;
		int y = p.y - 25;
		GradientPaint gradient = new GradientPaint(x, y, Color.BLUE, x + 50, y,
				Color.WHITE);
		g2.setPaint(gradient);
		g2.fill(new Rectangle2D.Double(x, y, 50, 50));
		BasicStroke wideStroke = new BasicStroke(2.0f);
		g2.setColor(Color.black);
		g2.setStroke(wideStroke);
		g2.draw(new Rectangle2D.Double(x, y, 50, 50));
	}

}

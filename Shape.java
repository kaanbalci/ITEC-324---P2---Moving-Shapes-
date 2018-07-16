import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * Shape class implements MovingShape handles drawing the shapes to be used and
 * 
 * @author Kaan Balci
 *
 */
public class Shape implements MovingShape {

	public Shape(int _x, int _y, int _pick) {

		pick = _pick;
		x = _x;
		y = _y;
		// yy = _y;
		// xx = 0;

	}

	/**
	 * Draw shapes
	 */
	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		if (pick == 1) {
			Ellipse2D.Double clockFrame = new Ellipse2D.Double(-100 + x, 0 + y,100, 100);
			Line2D.Double hourHand = new Line2D.Double(-50 + x, 15 + y, -50 + x, 50 + y);
			Line2D.Double minuteHand = new Line2D.Double(-20 + x, 25 + y, -60 + x, 50 + y);
			g2.setColor(Color.black);
			g2.draw(clockFrame);
			g2.draw(hourHand);
			g2.draw(minuteHand);
		} else if (pick == 2) {
			Point2D.Double p1 = new Point2D.Double(-30 + x, 0 + y);
			Point2D.Double p2 = new Point2D.Double(-10 + x, 20 + y);
			Point2D.Double p3 = new Point2D.Double(-30 + x, 20 + y);
			Point2D.Double p4 = new Point2D.Double(-30 + x, 40 + y);
			Point2D.Double p5 = new Point2D.Double(-45 + x, 40 + y);
			Point2D.Double p6 = new Point2D.Double(x, 40 + y);
			Point2D.Double p7 = new Point2D.Double(-40 + x, 60 + y);
			Point2D.Double p8 = new Point2D.Double(-30 + x, 60 + y);

			Line2D.Double flagPart = new Line2D.Double(p1, p2);
			Line2D.Double flagPart2 = new Line2D.Double(p2, p3);
			Line2D.Double flagPole = new Line2D.Double(p1, p4);
			Line2D.Double top = new Line2D.Double(p5, p6);
			Line2D.Double bottom = new Line2D.Double(p7, p8);
			Line2D.Double left = new Line2D.Double(p5, p7);
			Line2D.Double right = new Line2D.Double(p6, p8);

			g2.setColor(Color.black);
			g2.draw(flagPart);
			g2.draw(flagPart2);
			g2.draw(flagPole);
			g2.draw(top);
			g2.draw(bottom);
			g2.draw(left);
			g2.draw(right);
		} else {
			Point2D.Double line1 = new Point2D.Double(-65 + x, 30 + y);
			Point2D.Double line2 = new Point2D.Double(-65 + x, 90 + y);
			Point2D.Double line3 = new Point2D.Double(-110 + x, 60 + y);
			Point2D.Double line5 = new Point2D.Double(-10 + x, 60 + y);

			Line2D.Double top = new Line2D.Double(line1, line2);
			Line2D.Double body = new Line2D.Double(line3, line5);

			g2.setColor(Color.black);
			g2.draw(body);
			g2.draw(top);

		}

	}

	/**
	 * check for wrapping and movement
	 */
	@Override
	public void translate(int tx, int ty) {
		// check for wrapping
		if (x < 0 || x > 690) {
			tx = -x;
		}

		if (y < 0 || y > 690) {
			ty = -y;
		}

		x += tx;
		y += ty;
		// xx += tx;
		// yy += ty;
	}

	/**
	 * create varibales
	 */
	int pick;
	// private int xx;
	// private int yy;
	private int x;
	private int y;

}
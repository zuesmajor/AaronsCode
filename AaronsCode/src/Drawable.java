import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.Random;

public class Drawable {

	public static Random random = new Random();
	
	Point2D position = new Point(0, 0);
	
	public Point2D getPosition() {
		return (Point2D) position.clone();
	}

	public void setPosition(Point2D position) {
		this.position = position;
	}

	public void draw(Graphics2D g2d) {}
	
}

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;


public class Torso extends Drawable {
	int radius;
	
	public Torso() {
		radius = random.nextInt(30)+30;
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		g2d.drawOval((int)(position.getX() - radius), (int)(position.getY() - radius), radius*2, radius*2);
	}
}

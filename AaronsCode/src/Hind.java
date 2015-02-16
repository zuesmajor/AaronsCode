import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;


public class Hind extends Drawable {
	int radius;
	Leg frontLeg1 = new Leg();
	Leg frontLeg2 = new Leg();
	
	public Hind() {
		radius = random.nextInt(30)+30;
	}
	
	public Point2D CalculateLegPosition() {
		Point2D point = new Point();

		int angle = random.nextInt(30);
		
		point.setLocation(
				(int)(position.getX() + Math.cos((double)(angle + 75)/180*Math.PI) * radius),
				(int)(position.getY() + Math.sin((double)(angle + 75)/180*Math.PI) * radius)
		);
		
		return point;
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		g2d.drawOval((int)(position.getX() - radius), (int)(position.getY() - radius), radius*2, radius*2);

		frontLeg1.setPosition(CalculateLegPosition());
		frontLeg1.draw(g2d);

		frontLeg2.setPosition(CalculateLegPosition());
		frontLeg2.draw(g2d);
	}
	
	
}

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.Random;


public class Hind extends Drawable {
	int radius;
	Leg frontLeg1 = new Leg();
	Leg frontLeg2 = new Leg();
	Color color;
	int length;
	
	public Hind() {
		radius = random.nextInt(30)+30;
		length = random.nextInt(20);
		color = new Color(random.nextInt(150), random.nextInt(150), random.nextInt(150));
		

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
		
		g2d.setColor(color);
		g2d.fillOval((int)(position.getX() - radius), (int)(position.getY() - radius), radius*2, radius*2);
		g2d.setColor(Color.black);
		
		g2d.drawOval((int)(position.getX() - radius), (int)(position.getY() - radius), radius*2, radius*2);

		frontLeg1.setPosition(CalculateLegPosition());
		frontLeg1.draw(g2d);
		
		Random random = new Random();
		int angle = random.nextInt(250-180)+180;

		frontLeg2.setPosition(CalculateLegPosition());
		g2d.drawLine((int)(position.getX() + radius), (int)(position.getY()), 900, angle);
		frontLeg2.draw(g2d);
	}
	
}
	

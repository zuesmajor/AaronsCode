import java.awt.BasicStroke;
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
	
//	int backAngle;
	int backLength;
	int backThickness;
	Color backColor;
	
	// tail
	float tailAngles[] = new float[10];
	
	public Hind() {
		radius = random.nextInt(30)+30;
		length = random.nextInt(20);
		color = new Color(random.nextInt(150), random.nextInt(150), random.nextInt(150));
		backColor = new Color(random.nextInt(150), random.nextInt(150), random.nextInt(150));
		
//		backAngle = random.nextInt(30);
		backThickness = random.nextInt(100) + 1;
		backLength = random.nextInt(150) + 20;

		for (int i = 0; i < tailAngles.length/2; i++) {
			tailAngles[i] = random.nextInt(180-90);
		}
		
		for (int i = tailAngles.length/2; i < tailAngles.length; i++) {
			tailAngles[i] = random.nextInt(360);
		}
	}
	
	public Point2D CalculateLegPosition() {
		Point2D point = new Point();

		int angle = random.nextInt(30);
		
		point.setLocation(
				(int)(position.getX() + Math.cos((double)(angle + 75)/180*Math.PI) * radius) + backLength,
				(int)(position.getY() + Math.sin((double)(angle + 75)/180*Math.PI) * radius)
		);
		
		return point;
	}
	
	@Override
	public void draw(Graphics2D g2d) {

		g2d.setStroke(new BasicStroke(backThickness));
		g2d.setColor(backColor);
		g2d.drawLine((int)position.getX(), (int)position.getY(), (int)(position.getX() + backLength), (int)position.getY());
		
		g2d.setColor(color);
		g2d.fillOval((int)(position.getX() - radius) + backLength, (int)(position.getY() - radius), radius*2, radius*2);
		g2d.setColor(Color.black);
		
//		g2d.drawOval((int)(position.getX() - radius), (int)(position.getY() - radius), radius*2, radius*2);

		frontLeg1.setPosition(CalculateLegPosition());
		frontLeg1.draw(g2d);
		
//		Random random = new Random();
//		int angle = random.nextInt(250-180)+180;

		frontLeg2.setPosition(CalculateLegPosition());
//		g2d.drawLine((int)(position.getX() + radius + backLength), (int)(position.getY()), 900, angle);
//		g2d.drawLine(900, angle, 960, angle/2);
		int lastTailX = (int)(position.getX() + radius + backLength);
		int lastTailY = (int)(position.getY());
		for (int i = 0; i < tailAngles.length; i++) {
			int nextTailX = (int) (lastTailX + Math.cos(tailAngles[i]/180*Math.PI) * 10);
			int nextTailY = (int) (lastTailY + Math.sin(tailAngles[i]/180*Math.PI) * 10);
			g2d.drawLine(
					lastTailX,
					lastTailY,
					nextTailX,
					nextTailY
					);
			lastTailX = nextTailX;
			lastTailY = nextTailY;
		}
		frontLeg2.draw(g2d);

	}
	
}
	

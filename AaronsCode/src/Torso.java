import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;


public class Torso extends Drawable {
	int radius;
	Color color;
	
	Leg frontLeg1 = new Leg();
	Leg frontLeg2 = new Leg();
	Neck neck = new Neck();
	
	public Torso() {
		radius = random.nextInt(30)+30;
		color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
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
	
	public Point2D CalculateNeckPosition() 
	{
		Point2D point = new Point();

		int angle = random.nextInt(90);
		
		point.setLocation(
				(int)(position.getX() + Math.cos((double)(angle + 180)/180*Math.PI) * radius),
				(int)(position.getY() + Math.sin((double)(angle + 180)/180*Math.PI) * radius)
		);
		
		return point;
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(color);
		g2d.fillOval((int)(position.getX() - radius), (int)(position.getY() - radius), radius*2, radius*2);
		g2d.setColor(Color.black);

		frontLeg1.setPosition(CalculateLegPosition());
		frontLeg1.draw(g2d);

		frontLeg2.setPosition(CalculateLegPosition());
		frontLeg2.draw(g2d);
		
		neck.setPosition(CalculateNeckPosition());
		neck.draw(g2d);
	}
	
	/*public void drawBack(Graphics2D g2d){
		g2d.setColor(color);
		g2d.drawLine((int)neck.position.getX(), (int)neck.position.getY(), (int)hind.position.getX(), (int)hind.position.getY());
	}*/
	
}

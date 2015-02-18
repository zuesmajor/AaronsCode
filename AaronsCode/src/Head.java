

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;

public class Head extends Drawable
{
	private static Ear ear1;
	private static Ear ear2;
	private static int radius;
	private static Color color;
	
	Eye eye1 = new Eye();
	Eye eye2 = new Eye();

	Mouth mouth = new Mouth();
	
	int eye1Angle;
	int eye1Distance;

	int eye2Angle;
	int eye2Distance;
	
	int mouthDistance;
	
	public Head()
	{
		radius = random.nextInt(30)+30;

		eye1Angle = random.nextInt(30);
		eye1Distance = random.nextInt(Math.abs(radius-10)+1)+10;

		eye2Angle = random.nextInt(30);
		eye2Distance = random.nextInt(Math.abs(radius-10)+1)+10;

		mouthDistance = random.nextInt(radius-5)+5;
	}

	Point2D calculateEye1Position()
	{
		Point2D point = new Point(
				(int) (position.getX() + Math.cos((eye1Angle+180)/180*Math.PI)*eye1Distance),
				(int) (position.getY() + Math.sin((eye1Angle+180)/180*Math.PI)*eye1Distance)
		);
		return point;
	}

	Point2D calculateEye2Position()
	{
		Point2D point = new Point(
				(int) (position.getX() + Math.cos((-eye2Angle)/180*Math.PI)*eye2Distance),
				(int) (position.getY() + Math.sin((-eye2Angle)/180*Math.PI)*eye2Distance)
		);
		return point;
	}

	Point2D calculateMouthPosition()
	{
		Point2D point = new Point(
				(int) (position.getX()),
				(int) (position.getY() + mouthDistance)
		);
		return point;
	}
	
	@Override
	public void draw(Graphics2D g2d) 
	{
		g2d.drawOval((int)(position.getX() - radius), (int)(position.getY() - radius), radius*2, radius*2);
		g2d.fillOval((int)(position.getX() - radius), (int)(position.getY() - radius), radius*2, radius*2);
		g2d.setColor(Color.red);

		eye1.setPosition(calculateEye1Position());
		eye1.draw(g2d);
		
		eye2.setPosition(calculateEye2Position());
		eye2.draw(g2d);
		
		mouth.setPosition(calculateMouthPosition());
		mouth.draw(g2d);
	}
	
}

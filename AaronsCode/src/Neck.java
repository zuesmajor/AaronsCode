

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;

public class Neck extends Drawable
{
	int angle;
	int length;
	Head head;
	double neckEndX, neckEndY;
	
	public Neck()
	{
		angle = random.nextInt(30);
		length = random.nextInt(100)+50;
		head = new Head();
	}
	@Override
	public void draw(Graphics2D g2d) 
	{
		neckEndX = position.getX() + Math.cos((double)(angle + 180)/180*Math.PI) * length;
		neckEndY = position.getY() + Math.sin((double)(angle + 180)/180*Math.PI) * length;

		g2d.drawLine(
				(int)(position.getX()),
				(int)(position.getY()),
				(int)(neckEndX),
				(int)(neckEndY)
		);
		
		head.setPosition(CalculateHeadPosition());
		head.draw(g2d);
	}
	public Point2D CalculateHeadPosition() 
	{
		Point2D point = new Point();

		int angle = random.nextInt(90);
		int radius = random.nextInt(10);
		
		point.setLocation(
				(int)(neckEndX),
				(int)(neckEndY)
		);
		
		return point;
	}

	
}



import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Point2D;

public class Ear extends Drawable 
{
	
	private Polygon poly;

	public Ear() 
	{
		
	}
	
	@Override
	public void draw(Graphics2D g2d) 
	{
		 poly = new Polygon(
                 new int[]{(int)position.getX() - 30, (int)position.getX(), (int)position.getX() + 10},
                 new int[]{(int)position.getY() - 80, (int)position.getY() - 100, (int)position.getY() - 80},
                 3);
		g2d.drawPolygon(poly);
		Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
		g2d.setColor(color);
		g2d.fillPolygon(poly);
	}

}

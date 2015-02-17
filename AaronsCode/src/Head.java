

import java.awt.Color;
import java.awt.Graphics2D;

public class Head extends Drawable
{
	private static Ear ear1;
	private static Ear ear2;
	private static int radius;
	private static Color color;
	
	public Head()
	{
		radius = random.nextInt(30)+30;
	}

	@Override
	public void draw(Graphics2D g2d) 
	{
		g2d.drawOval((int)(position.getX() - radius), (int)(position.getY() - radius), radius*2, radius*2);
		g2d.fillOval((int)(position.getX() - radius), (int)(position.getY() - radius), radius*2, radius*2);
		g2d.setColor(Color.red);
	}
	
}

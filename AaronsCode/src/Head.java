

import java.awt.Graphics2D;

import javax.swing.JComponent;

public class Head extends Drawable
{
	private static Ear ear1;
	private static Ear ear2;
	private static int radius;
	public Head()
	{
		radius = random.nextInt(30)+30;
	}

	@Override
	public void draw(Graphics2D g2d) 
	{
		g2d.drawOval((int)(position.getX() - radius), (int)(position.getY() - radius), radius*2, radius*2);
	}
	
}

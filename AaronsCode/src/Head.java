package cat;

import java.awt.Graphics2D;

import javax.swing.JComponent;

public class Head implements Drawable
{
	private static Ear ear1;
	private static Ear ear2;
	public Head(Neck n)
	{
		ear1 = new Ear(this);
		ear2 = new Ear(this);
	}

	@Override
	public void draw(Graphics2D g) 
	{
		
	}
	
}

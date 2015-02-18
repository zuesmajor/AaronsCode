import java.awt.Color;
import java.awt.Graphics2D;


public class Eye extends Drawable {

	int width;
	int height;

	int pupilWidth;
	int pupilHeight;
	int pupilAngle;
	
	Color color;
	Color pupilColor;
	
	public Eye()
	{
		color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
		width = random.nextInt(30)+5;
		height = random.nextInt(30)+5;

		pupilColor = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
		pupilWidth = random.nextInt(Math.abs(width-5)+1)+5;
		pupilHeight = random.nextInt(Math.abs(height-5)+1)+5;
		pupilAngle = random.nextInt(360);
	}

	@Override
	public void draw(Graphics2D g2d) 
	{
		g2d.setColor(color);
		g2d.fillOval(
				(int)(position.getX() - width/2),
				(int)(position.getY() - height/2),
				(int)width, (int)height);

		g2d.setColor(pupilColor);
		g2d.fillOval(
				(int)(position.getX() + Math.cos(pupilAngle/180*Math.PI) * (width/2 - pupilWidth/2)),
				(int)(position.getY() + Math.sin(pupilAngle/180*Math.PI) * (width/2 - pupilWidth/2)),
				(int)pupilWidth/2, (int)pupilHeight/2);
	}
	
}

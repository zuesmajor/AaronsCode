import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


public class Mouth extends Drawable {

	float angle1;
	float angle2;
	
	int length1;
	int length2;
	
	Color color;
	float mouthWidth;
	
	public Mouth()
	{
		angle1 = random.nextInt(180) + 90;
		angle2 = random.nextInt(180) - 90;

		length1 = random.nextInt(20)+5;
		length2 = random.nextInt(20)+5;
		
		color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
		mouthWidth = random.nextInt(5) + 1;
	}
	
	@Override
	public void draw(Graphics2D g2d) 
	{

		g2d.setColor(color);
		g2d.setStroke(new BasicStroke(mouthWidth));

		g2d.drawLine(
				(int)(position.getX()),
				(int)(position.getY()),
				(int)(position.getX() + Math.cos(angle1/180*Math.PI)*length1),
				(int)(position.getY() + Math.sin(angle1/180*Math.PI)*length1)
		);

		g2d.drawLine(
				(int)(position.getX()),
				(int)(position.getY()),
				(int)(position.getX() + Math.cos(angle2/180*Math.PI)*length2),
				(int)(position.getY() + Math.sin(angle2/180*Math.PI)*length2)
		);
		
	}
	
}

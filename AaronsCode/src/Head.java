

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;

public class Head extends Drawable
{
	private static Ear ear1 = new Ear();
	private static Ear ear2 = new Ear();
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
	
	static String syllable[] = {
		"schmoo",
		"poo",
		"goo",
		"loo",
		"pa",
		"too",
		"tootie",
		"ska",
		"dookie",
		"doo"
	};
	
	static String firstName[] = {
			"Fart",
			"Poop",
			"Cool ",
			"Rad ",
			"Ugly ",
			"Stupid ",
			"Pretty ",
			"Scandalous ",
			"Peace",
			"War",
			"Evil ",
			"Alright "
	};
	
	static String lastName[] = {
			"Giraffe",
			"Cat",
			"Dog",
			"Monkey",
			"Snake",
			"Bird",
			"Horse",
			"Guy"
	};
	
	String name;
	
	public Head()
	{
		color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
		radius = random.nextInt(30)+30;

		eye1Angle = random.nextInt(30);
		eye1Distance = random.nextInt(Math.abs(radius-10)+1)+10;

		eye2Angle = random.nextInt(30);
		eye2Distance = random.nextInt(Math.abs(radius-10)+1)+10;

		mouthDistance = random.nextInt(radius-5)+5;
		
		name = "";
		for (int i = 0; i < 5; i++) {
			name += syllable[random.nextInt(syllable.length)];
		}
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		name += " the ";
		name += firstName[random.nextInt(firstName.length)] + lastName[random.nextInt(lastName.length)];
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

	Point2D CalculateEarPosition() 
	{
		Point2D point = new Point();
	
		double legEndX = (position.getX()) ;
		double legEndY = (position.getY() - radius/7) ;
		point.setLocation(legEndX+20, legEndY+40);
		return point;
	}
	
	@Override
	public void draw(Graphics2D g2d) 
	{
		g2d.setColor(color);
		g2d.drawOval((int)(position.getX() - radius), (int)(position.getY() - radius), radius*2, radius*2);
		g2d.fillOval((int)(position.getX() - radius), (int)(position.getY() - radius), radius*2, radius*2);
		g2d.setColor(Color.red);

		eye1.setPosition(calculateEye1Position());
		eye1.draw(g2d);
		
		eye2.setPosition(calculateEye2Position());
		eye2.draw(g2d);
		
		mouth.setPosition(calculateMouthPosition());
		mouth.draw(g2d);
		

		ear1.setPosition(CalculateEarPosition());
		ear1.draw(g2d);
		
		Point p = new Point();
		p.setLocation(position.getX() - radius/8, position.getY() - radius/7+40);
		ear2.setPosition(p);
		ear2.draw(g2d);

		g2d.setColor(Color.black);
		g2d.setFont(new Font("Arial", Font.BOLD, 30));
		g2d.drawString(name, (int)position.getX(), (int)position.getY() - radius - 20);
	}
	
}

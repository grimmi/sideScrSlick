package entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import util.images;

public class block extends objekt{

	private float height,width;
	
	private Color color;
	
	private images i;
	
	public block(environment u) throws SlickException{
		super(u);
		i = new images();
		super.setImage(i.blueBlock);
		height = 0;
		width = 0;
		color = Color.blue;
	}
	
	public block(float x, float y) throws SlickException{
		this(new environment());
		setX(x);
		setY(y);
	}
}

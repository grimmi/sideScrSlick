package entities;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import util.images;

public class objekt {

	private float x,y;
	private float renderX, renderY;
	private float speed;
	private int dir;	// rechts, links, oben, unten
	
	private images i;
	private Image image;
	
	public objekt(){
		x = 0;
		y = 0;
		renderX = 0;
		renderY = 0;
		speed = 0;
		dir = 2;
	}
	
	public void setX(float x){
		this.x = x;
	}
	
	public float getX(){
		return x;
	}
	
	public void setY(float y){
		this.y = y;
	}
	
	public float getY(){
		return y;
	}
	
	public void setPos(float x, float y){
		setX(x);
		setY(y);
	}
	
	public float[] getPos(){
		float[] pos = {x,y};
		return pos;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	public void draw(Graphics g){
		g.drawImage(getImage(),x,y);
	}
	
}

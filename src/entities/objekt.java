package entities;

public class objekt {

	private float x,y;
	private float renderX, renderY;
	private float speed;
	private int dir;	// rechts, links, oben, unten
	
	public objekt(){
		x = 0;
		y = 0;
		renderX = 0;
		renderY = 0;
		speed = 0;
		dir = 2;
	}
	
	public float[] getPos(){
		float[] pos = {x,y};
		return pos;
	}

}

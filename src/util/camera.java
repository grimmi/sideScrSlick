package util;

import entities.objekt;

public class camera {

	private float x,y;
	private float camWidth, camHeight;
	
	private co c;
	
	public camera(){
		c = new co();
		camWidth = c.WINDOW_X;
		camHeight = c.WINDOW_Y;
		x = 0;
		y = 0;
	}
	
	public boolean inCamera(objekt o){
		float checkX = o.getPos()[0];
		float checkY = o.getPos()[1];
		if((checkX >= x && checkX <= x+camWidth) && (checkY >= y && checkY <= y+camHeight)){
			return true;
		}
		else
			return false;
	}

}

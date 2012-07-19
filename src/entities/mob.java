package entities;

import util.co;

public class mob extends objekt {
	private int dir;
	private int[] allowedDirs;
	private float speed;
	private float maxSpeed;
	
	public mob(){
		super();
		dir = 0;
		allowedDirs = new int[8];
		speed = 0;
		maxSpeed = 100;
	}
	
	
	/*
	 * 	  8	1 2
	 * 	  7	0 3
	 * 	  6 5 4	
	 */		  
	public void move(){
		switch(getDir()){
			case 1: setY(getY()-speed);
					setX(getX());
					break;
			case 2: setY(getY()-(speed/2));
					setX(getX()+(speed/2));
					break;
			case 3: setY(getY());
					setX(getX()+speed);
					break;
			case 4: setY(getY()+(speed/2));
					setX(getX()+(speed/2));
					break;
			case 5: setY(getY()+speed);
					setX(getX());
					break;
			case 6:	setY(getY()+(speed/2));
					setX(getX()-(speed/2));
					break;
			case 7: setY(getY());
					setX(getX()-speed);
					break;
			case 8: setY(getY()-(speed/2));
					setX(getX()-(speed/2));
					break;
			case 0: setY(getY());
					setX(getX());
					break;
		}
	}
	
	public void setDir(int d){
		if(d > -1 && d < 9){
			dir = d;
		}
		else{
			//throw new IllegalDirException();
		}
	}
	
	public int getDir(){
		return dir;
	}
	
	public void setSpeed(float s){
		speed = s;
	}
	
	public float getSpeed(){
		return speed;
	}
}

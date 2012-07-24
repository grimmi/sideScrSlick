package entities;

import util.co;


public class mob extends objekt {
	private int dir;
	private int[] allowedDirs;
	private float speed;
	private float maxSpeed;
	private boolean jump;
	private boolean fall;
	private float jumpheight;
	private float jumpSpeed;
	private float maxJumpSpeed = 10;
	private boolean verticalAllowed;
	private float baseLine = co.WINDOW_Y-100;
	private float jumpDiff = 0.5f;
	
	public mob(environment u){
		super(u);
		dir = 0;
		setAllowedDirs(new int[8]);
		speed = 0;
		setMaxSpeed(100);
	}
	
	
	/*
	 * 	  8	1 2
	 * 	  7	0 3
	 * 	  6 5 4	
	 */		  
	public void move(){
		if(isJump()){
			setY(getY()-getJumpSpeed());
			setJumpSpeed(getJumpSpeed()-jumpDiff);
			if(getJumpSpeed() == 0){
				setJump(false);
				setJumpSpeed(getMaxJumpSpeed());
				setFall(true);
			}
		}
		if(isFall()){
			setY(getY()+getJumpSpeed());
			setJumpSpeed(getJumpSpeed()-jumpDiff);
			if(getJumpSpeed() == 0){
				setFall(false);
			}
		}
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
			case 0: //setY(getY());
					//setX(getX());
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
	
	public void jump(){
		if(!isJump() && !isFall()){
			setJump(true);
			setJumpSpeed(getMaxJumpSpeed());
		}
	}


	public int[] getAllowedDirs() {
		return allowedDirs;
	}


	public void setAllowedDirs(int[] allowedDirs) {
		this.allowedDirs = allowedDirs;
	}


	public float getMaxSpeed() {
		return maxSpeed;
	}


	public void setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}


	public boolean isJump() {
		return jump;
	}


	public void setJump(boolean jump) {
		this.jump = jump;
	}


	public float getJumpheight() {
		return jumpheight;
	}


	public void setJumpheight(float jumpheight) {
		this.jumpheight = jumpheight;
	}
	
	public void forbidVertical(){
		verticalAllowed = false;
	}
	
	public void allowVertical(){
		verticalAllowed = true;
	}
	
	public boolean getVerticalAllowed(){
		return verticalAllowed;
	}
	
	public void setVerticalAllowed(boolean allowed){
		verticalAllowed = allowed;
	}
	
	public void setJumpSpeed(float js){
		if(js > 0){
			jumpSpeed = js;
		}
		else{
			jumpSpeed = 0;
		}
	}
	
	public float getJumpSpeed(){
		return jumpSpeed;
	}
	
	public void checkCollision(environment u){
		// umgebungskollisionen
	}


	public float getMaxJumpSpeed() {
		return maxJumpSpeed;
	}


	public void setMaxJumpSpeed(float maxJumpSpeed) {
		this.maxJumpSpeed = maxJumpSpeed;
	}


	public boolean isFall() {
		return fall;
	}


	public void setFall(boolean fall) {
		this.fall = fall;
	}
	
}

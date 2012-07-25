package entities;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

import util.co;
import util.control;


public class mob extends objekt {
	private int dir;
	private ArrayList<Integer> dirs;
	private float speed;
	private float maxSpeed;
	private boolean jump;
	private boolean fall;
	private float jumpheight;
	private float jumpSpeed;
	private float maxJumpSpeed = 10f;
	private float jumpDiff = 0.5f;
	private control control;
	
	public mob(environment u) throws SlickException{
		super(u);
		init();
	}
	
	public mob(float x, float y, environment u) throws SlickException{
		super(x,y,u);
		init();
	}
	
	public void init(){
		dir = 0;
		dirs = new ArrayList<Integer>();
		speed = 4f;
		setMaxSpeed(100);
		control = new control();
	}
	
	public void move(){
		if(isJump()){
			setY(getY()-getJumpSpeed());
			setJumpSpeed(getJumpSpeed()-jumpDiff);
			if(getJumpSpeed() == 0){
				setJump(false);
				setJumpSpeed(getMaxJumpSpeed());
			}
		}
		if(!isJump()){
			setY(getY()+getSpeed());
		}
		for(int aDir : dirs){
			switch(aDir){
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
	}
	
	public void setDir(int d){
		if(!dirs.contains(d)){
			dirs.add(d);
		}
		if(d == 0){
			dirs.clear();
		}
	}
	
	public int getDir(){
		return dir;
	}
	
	public void removeDir(int d){
		if(dirs.contains((Integer)d)){	// cast to Integer to differentiate between index and object
			dirs.remove((Integer)d);
		}
	}
	
	public void setSpeed(float s){
		speed = s;
	}
	
	public float getSpeed(){
		return speed;
	}
	
	public void jump(){
		if(!isJump() && !isFall() && getEnvironmentCollisionList(getEnvironment()).contains(co.COLLISION_DOWN)){
			setJump(true);
			setJumpSpeed(getMaxJumpSpeed());
		}
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


	public control getControl() {
		return control;
	}


	public void setControl(control control) {
		this.control = control;
	}
	
	public void doYourThing(GameContainer gc, environment env){
		getEnvironmentCollisionList(env);
		if(this instanceof player){
			getControl().playerControl(gc, this);
		}
		move();
	}
}

package logic;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import util.co;
import util.debug;
import util.images;
import util.control;

import entities.block;
import entities.mob;
import entities.player;
import entities.environment;

public class GameplayState extends BasicGameState {

	private int gameStateID;
	
	private boolean debugOn;
	private debug dbg;
	
	private Input in;
	
	private co c;
	private images i;
	
	environment gameplayEnvironment;
	
	player p;
	mob neuMob;
	
	private control control;
	
	long lastKITick;
	
	public GameplayState(int id) {
		gameStateID = id;
	}
	
	public int getID(){
		return gameStateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		lastKITick = System.currentTimeMillis();
		reset(gc);
		p.setImage(i.blueBlock);
		p.setSpeed(5f);
		neuMob = new mob(gameplayEnvironment);
		neuMob.setPos(600, 500);
		neuMob.setSpeed(3.5f);
		gameplayEnvironment.addObjekt(neuMob);
		float bW = i.blueBlock.getWidth();
		float bH = i.blueBlock.getHeight();
		float gW = 0f;
		int a = 0;
		while(gW < c.WINDOW_X){
			gameplayEnvironment.addObjekt(new block((bW*a),c.WINDOW_Y-(bH+0)));
			a++;
			gW += bW;
		}
		gameplayEnvironment.addObjekt(new mob(p.getX()+200,p.getY(),gameplayEnvironment));
		gameplayEnvironment.addObjekt(new mob(p.getX()+300,p.getY()-300,gameplayEnvironment));
		gameplayEnvironment.addObjekt(new mob(p.getX()+800,p.getY(),gameplayEnvironment));
		gameplayEnvironment.addObjekt(p);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		gameplayEnvironment.draw(g);
		p.draw(g);
		if(debugOn)dbg.showDebug(g,p,gameplayEnvironment);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		p.doYourThing(gc,gameplayEnvironment);
		gameplayEnvironment.doYourThing(gc);
		if((System.currentTimeMillis() - lastKITick) > 10){
			lastKITick = System.currentTimeMillis();
			double t = Math.random();
			if(t > 0.5 || neuMob.getEnvironmentCollisionList(gameplayEnvironment).contains(co.COLLISION_LEFT)){
				neuMob.removeDir(co.DIR_LEFT);
				neuMob.setDir(co.DIR_RIGHT);
			}
			else if(t <= 0.5f || neuMob.getEnvironmentCollisionList(gameplayEnvironment).contains(co.COLLISION_RIGHT)){
				neuMob.removeDir(co.DIR_RIGHT);
				neuMob.setDir(co.DIR_LEFT);
			}
		}
	}
	
	public void reset(GameContainer gc) throws SlickException{
		debugOn = true;
		dbg = new debug(gc);
		c = new co();
		gameplayEnvironment = new environment();
		i = new images();
		in = gc.getInput();
		p = new player(gameplayEnvironment);
		p.setPos(100, c.WINDOW_Y-100);
	}

}

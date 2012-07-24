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
import util.keyboard;

import entities.block;
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
	
	public GameplayState(int id) {
		gameStateID = id;
	}
	
	public int getID(){
		return gameStateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		reset(gc);
		p.setImage(i.blueBlock);
		p.setSpeed(10f);
		float bW = i.blueBlock.getWidth();
		float bH = i.blueBlock.getHeight();
		float gW = 0f;
		int a = 0;
		/*
		while(gW < c.WINDOW_X){
			gameplayEnvironment.addObjekt(new block((bW*a),c.WINDOW_Y-(bH+0)));
			a++;
			gW += bW;
		}
		*/
		gameplayEnvironment.addObjekt(new block(p.getX()+200,p.getY()));
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		gameplayEnvironment.draw(g);
		p.draw(g);
		if(debugOn)dbg.showDebug(g,p,gameplayEnvironment);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		steuerung(gc);
		p.move();
		p.getEnvironmentCollisionList(gameplayEnvironment);
	}
	
	public void steuerung(GameContainer gc){
		if(in.isKeyPressed(co.MOVE_LEFT)){
			p.setDir(co.DIR_LEFT);
		}
		if(in.isKeyPressed(co.MOVE_RIGHT)){
			p.setDir(co.DIR_RIGHT);
		}
		if(in.isKeyPressed(co.MOVE_JUMP)){
			p.jump();
		}
		if(!in.isKeyDown(co.MOVE_LEFT) && !in.isKeyDown(co.MOVE_RIGHT)){
			p.setDir(co.DIR_NODIR);
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

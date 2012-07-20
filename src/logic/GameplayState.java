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
import entities.umgebung;

public class GameplayState extends BasicGameState {

	private int gameStateID;
	
	private boolean debugOn;
	private debug dbg;
	
	private Input in;
	
	private co c;
	private images i;
	
	umgebung u;
	
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
		while(gW < c.WINDOW_X){
			u.addObjekt(new block((bW*a),c.WINDOW_Y-(bH+0)));
			a++;
			gW += bW;
		}	
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("GameplayState", 300, 300);
		u.draw(g);
		p.draw(g);
		if(debugOn)dbg.showDebug(g,p);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		steuerung(gc);
		p.move();
		p.checkCollision(u);
	}
	
	public void steuerung(GameContainer gc){
		if(in.isKeyDown(co.MOVE_UP)){
			if(in.isKeyDown(co.MOVE_RIGHT)){
				p.setDir(co.DIR_UP_RIGHT);
			}
			else if(in.isKeyDown(co.MOVE_LEFT)){
				p.setDir(co.DIR_UP_LEFT);
			}
			else{
				p.setDir(co.DIR_UP);
			}
		}
		if(in.isKeyDown(co.MOVE_RIGHT)){
			if(in.isKeyDown(co.MOVE_UP)){
				p.setDir(co.DIR_UP_RIGHT);
			}
			else if(in.isKeyDown(co.MOVE_DOWN)){
				p.setDir(co.DIR_DOWN_RIGHT);
			}
			else{
				p.setDir(co.DIR_RIGHT);				
			}
		}
		if(in.isKeyDown(co.MOVE_DOWN)){
			if(in.isKeyDown(co.MOVE_RIGHT)){
				p.setDir(co.DIR_DOWN_RIGHT);
			}
			else if(in.isKeyDown(co.MOVE_LEFT)){
				p.setDir(co.DIR_DOWN_LEFT);
			}
			else{
				p.setDir(co.DIR_DOWN);
			}
		}
		if(in.isKeyDown(co.MOVE_LEFT)){
			if(in.isKeyDown(co.MOVE_UP)){
				p.setDir(co.DIR_UP_LEFT);
			}
			else if(in.isKeyDown(co.MOVE_DOWN)){
				p.setDir(co.DIR_DOWN_LEFT);
			}
			else{
				p.setDir(co.DIR_LEFT);				
			}
		}
		if(in.isKeyPressed(co.MOVE_JUMP)){
			p.jump();
		}
		if(!in.isKeyDown(co.MOVE_UP) && !in.isKeyDown(co.MOVE_DOWN) && !in.isKeyDown(co.MOVE_LEFT) && !in.isKeyDown(co.MOVE_RIGHT)){
			p.setDir(0);
		}
		
	}
	
	public void reset(GameContainer gc) throws SlickException{
		debugOn = true;
		dbg = new debug(gc);
		c = new co();
		u = new umgebung();
		i = new images();
		in = gc.getInput();
		p = new player();
		p.setPos(100, c.WINDOW_Y-100);
	}

}

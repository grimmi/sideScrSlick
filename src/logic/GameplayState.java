package logic;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import util.co;
import util.debug;
import util.images;
import util.keyboard;

import entities.block;
import entities.umgebung;

public class GameplayState extends BasicGameState {

	private int gameStateID;
	
	private boolean debugOn;
	private debug dbg;
	
	private keyboard kb;
	private Input in;
	
	private co c;
	private images i;
	
	umgebung u;
	
	block spieler;
	
	public GameplayState(int id) {
		gameStateID = id;
	}
	
	public int getID(){
		return gameStateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		debugOn = true;
		dbg = new debug(gc);
		c = new co();
		u = new umgebung();
		i = new images();
		in = gc.getInput();
		kb = new keyboard(gc);
		float bW = i.blueBlock.getWidth();
		float bH = i.blueBlock.getHeight();
		float gW = 0f;
		int a = 0;
		while(gW < c.WINDOW_X){
			u.addObjekt(new block((bW*a),c.WINDOW_Y-(bH+0)));
			a++;
			gW += bW;
		}	
		spieler = new block(200, 200);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("GameplayState", 300, 300);
		u.draw(g);
		spieler.draw(g);
		if(debugOn)dbg.showDebug(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		kb.update();
		steuerung();
	}
	
	public void steuerung(){
		if(in.isKeyDown(c.MOVE_RIGHT) && spieler.getX() < c.WINDOW_X-(spieler.getImage().getWidth())){
			spieler.setX(spieler.getX()+3);
		}
		if(in.isKeyDown(c.MOVE_LEFT) && spieler.getX() > -1){
			spieler.setX(spieler.getX()-3);
		}
		if(in.isKeyDown(c.MOVE_UP) && spieler.getY() > -1){
			spieler.setY(spieler.getY()-3);
		}
		if(in.isKeyDown(c.MOVE_DOWN) && spieler.getY() < (c.WINDOW_Y-(spieler.getImage().getHeight()*2))){
			spieler.setY(spieler.getY()+3);
		}
	}

}

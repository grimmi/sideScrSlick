package states;
/*
 * 	==========================INSPIRATIONAL QUOTE=======================================
 * 	## Beware of bugs in the above code; I have only proved it correct, not tried it. ##
 * 	## 																  donald e. knuth ##
 * 	====================================================================================
 */

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import util.constants;
import util.Keyboard;
import util.debug;

public class MainMenuState extends BasicGameState{

	boolean debugOn;
	debug dbg;
	
	constants c;
	
	Font dadha;
	Font cNew;
	int auswahl;
	
	Input in;
	Keyboard kb;
	
	float mouseX;
	float mouseY;
	
	int key;
	String keyName;
	
	
	
	int gameStateID = 0;
	
	public MainMenuState(int id){
		gameStateID = id;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		in = gc.getInput();
		kb = new Keyboard(gc);
		key = 0;
		keyName = "";
		dbg = new debug(gc);
		debugOn = false;
		dadha = new AngelCodeFont("/res/font/dadha.fnt","/res/font/dadha_00.png");
		cNew = new AngelCodeFont("/res/font/courierNew.fnt","/res/font/courierNew_0.png");
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		mouseX = in.getMouseX();
		mouseY = in.getMouseY();
		kb.update();
		if(key == Input.KEY_ENTER){
			sbg.enterState(sideScrSlick.GAMEPLAYSTATE);
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		if(debugOn)dbg.showDebug(g);
	}

	@Override
	public int getID() {
		return gameStateID;
	}		
}

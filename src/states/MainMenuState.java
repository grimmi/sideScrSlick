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

public class MainMenuState extends BasicGameState{

	boolean debug;
	
	constants c;
	
	Font dadha;
	Font cNew;
	int auswahl;
	
	Input in;
	float mouseX;
	float mouseY;
	
	int lastKeyPressed;
	
	
	
	int gameStateID = 0;
	
	public MainMenuState(int id){
		gameStateID = id;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		in = gc.getInput();
		lastKeyPressed = 0;
		debug = true;
		dadha = new AngelCodeFont("/res/font/dadha.fnt","/res/font/dadha_00.png");
		cNew = new AngelCodeFont("/res/font/courierNew.fnt","/res/font/courierNew_0.png");
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		mouseX = in.getMouseX();
		mouseY = in.getMouseY();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.resetTransform();
		g.setFont(dadha);
		g.drawString("Hauptmenü!", 400, 300);
		
		if(debug)showDebug(g);
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return gameStateID;
	}	
	
	public void showDebug(Graphics g){
		g.setFont(cNew);
		g.scale(0.75f, 0.75f);
		String mouseDebug = (int)mouseX+" | "+(int)mouseY;
		cNew.drawString(c.WINDOW_X+160, 10, mouseDebug, Color.white);
	}
}

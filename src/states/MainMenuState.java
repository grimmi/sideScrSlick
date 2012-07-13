package states;
/*
 * 	==========================INSPIRATIONAL QUOTE=======================================
 * 	## Beware of bugs in the above code; I have only proved it correct, not tried it. ##
 * 	## 																  donald e. knuth ##
 * 	====================================================================================
 */

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenuState extends BasicGameState{

	Font dadha;
	
	
	
	
	int gameStateID = 0;
	
	public MainMenuState(int id){
		gameStateID = id;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		dadha = new AngelCodeFont("/res/font/dadha.fnt","/res/font/dadha_00.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.setFont(dadha);
		g.drawString("Hauptmenü!", 400, 300);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return gameStateID;
	}	
	
}

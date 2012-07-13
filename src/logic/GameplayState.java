package logic;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameplayState extends BasicGameState {

	private int gameStateID;
		
	public static void main(String[] args) {

	}
	
	public GameplayState(int id) {
		gameStateID = id;
	}
	
	public int getID(){
		return gameStateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
			
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("GameplayState", 300, 300);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
	}

}

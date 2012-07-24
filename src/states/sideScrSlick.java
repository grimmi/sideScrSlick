package states;

import logic.GameplayState;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import util.co;

public class sideScrSlick extends StateBasedGame {

	public static final int MAINMENUSTATE	          	= 0;
	public static final int GAMEPLAYSTATE				= 1;
    
	static co c;
	
	public sideScrSlick()
	{
		super("Sidescroller Slick");
		this.addState(new MainMenuState(MAINMENUSTATE));
		this.addState(new GameplayState(GAMEPLAYSTATE));
        this.enterState(MAINMENUSTATE);
	}
	
	public static void main(String[] args) throws SlickException
	{ 
		AppGameContainer sideScrSlick = new AppGameContainer(new sideScrSlick());		
		sideScrSlick.setDisplayMode(c.WINDOW_X, c.WINDOW_Y, false);
		sideScrSlick.setShowFPS(false);
		sideScrSlick.setTargetFrameRate(60);
		sideScrSlick.start();
	}

	@Override
	public void initStatesList(GameContainer gameContainer) throws SlickException {
		this.getState(MAINMENUSTATE).init(gameContainer, this);	
		this.getState(GAMEPLAYSTATE).init(gameContainer, this);
	}



}
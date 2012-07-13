package util;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class debug {

	private Font dadha;
	private Font cNew;
	
	co c;
	
	Input in;
	keyboard kb;
	
	float mouseX,mouseY;
	
	public debug(GameContainer gc) throws SlickException{
		c = new co();
		in = gc.getInput();
		kb = new keyboard(gc);
		dadha = new AngelCodeFont("/res/font/dadha.fnt","/res/font/dadha_00.png");
		cNew = new AngelCodeFont("/res/font/courierNew.fnt","/res/font/courierNew_0.png");
	}
	

	public void showDebug(Graphics g){
		g.setFont(cNew);
		g.scale(0.75f, 0.75f);
		mouseX = in.getMouseX();
		mouseY = in.getMouseY();
		String mouseDebug = (int)mouseX+" | "+(int)mouseY;
		String keyPressed = ""+kb.isAnyKey();
		cNew.drawString(c.WINDOW_X+160, 10, mouseDebug, Color.white);
		cNew.drawString(c.WINDOW_X+160, 30, keyPressed, Color.white);
		cNew.drawString(c.WINDOW_X+160, 50, kb.getKeyName(), Color.white);
	}

}

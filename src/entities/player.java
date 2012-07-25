package entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import util.fonts;

public class player extends mob{
	
	private String name = "Bob";
	private fonts f;
	
	public player(environment u) throws SlickException{
		super(u);
		f = new fonts();
	}
	
	public void draw(Graphics g){
		super.draw(g);
		g.setFont(f.dadha);
		g.drawString(name, getX(), getY()-15);
	}
}

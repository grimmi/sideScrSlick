package util;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import entities.environment;
import entities.player;

public class debug {

	fonts f;
	
	co c;
	
	Input in;
	keyboard kb;
	
	float mouseX,mouseY;
	
	public debug(GameContainer gc) throws SlickException{
		c = new co();
		in = gc.getInput();
		kb = new keyboard(gc);
		f = new fonts();
	}
	

	public void showDebug(Graphics g){
		g.setFont(f.cNew);
		g.scale(0.75f, 0.75f);
		mouseX = in.getMouseX();
		mouseY = in.getMouseY();
		String mouseDebug = (int)mouseX+" | "+(int)mouseY;
		String keyPressed = ""+kb.isAnyKey();
		f.cNew.drawString(c.WINDOW_X+160, 10, mouseDebug, Color.white);
		f.cNew.drawString(c.WINDOW_X+160, 30, keyPressed, Color.white);
		f.cNew.drawString(c.WINDOW_X+160, 50, kb.getKeyName(), Color.white);
	}
	
	public void showDebug(Graphics g, player p, environment u){
		showDebug(g);
		/*f.cNew.drawString(c.WINDOW_X+160, 70, "p.dir: "+p.getDir(), Color.white);
		f.cNew.drawString(c.WINDOW_X, 110, p.getX()+" - "+(p.getX()+p.getWidth()), Color.white);
		f.cNew.drawString(c.WINDOW_X+16, 130, p.getY()+" - "+(p.getY()+p.getHeight()), Color.white);
		f.cNew.drawString(c.WINDOW_X-100, 130, "jump: "+p.isJump()+" | fall: "+p.isFall());
		f.cNew.drawString(c.WINDOW_X+160, 150, "jumpSpeed: "+p.getJumpSpeed());
		*/
		for(int i = 0; i < p.getEnvironmentCollisionList(u).size(); i++){
			f.cNew.drawString(0, 20*i, p.getEnvironmentCollisionList(u).get(i));
		}
		
	}

}

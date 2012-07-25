package util;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import entities.mob;

public class control {
	
	public void mobControl(GameContainer gc, mob m){
		Input in = gc.getInput();
		if(in.isKeyDown(co.MOVE_LEFT)){
			m.setDir(co.DIR_LEFT);
		}
		else{
			m.removeDir(co.DIR_LEFT);
		}
		if(in.isKeyDown(co.MOVE_RIGHT)){
			m.setDir(co.DIR_RIGHT);
		}
		else{
			m.removeDir(co.DIR_RIGHT);
		}
		if(in.isKeyDown(co.MOVE_UP)){
			m.setDir(co.DIR_UP);
		}
		else{
			m.removeDir(co.DIR_UP);
		}
		if(in.isKeyDown(co.MOVE_DOWN)){
			m.setDir(co.DIR_DOWN);
		}
		else{
			m.removeDir(co.DIR_DOWN);
		}
		if(in.isKeyDown(co.MOVE_JUMP)){
			m.jump();
		}
		if(!in.isKeyDown(co.MOVE_LEFT) && !in.isKeyDown(co.MOVE_RIGHT) && !in.isKeyDown(co.MOVE_UP) && !in.isKeyDown(co.MOVE_DOWN)){
			m.setDir(co.DIR_NODIR);
		}
	}
	
}

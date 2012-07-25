package entities;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class environment {

	private ArrayList<objekt> objekte;

	public environment(){
		objekte = new ArrayList<objekt>();
	}
	
	public ArrayList<objekt> getEnvironment(){
		return objekte;
	}
	
	public void addObjekt(objekt o){
		objekte.add(o);
	}
	
	public void draw(Graphics g){
		if(!objekte.isEmpty()){
			for(int i = 0; i < objekte.size(); i++){
				objekte.get(i).draw(g);
			}
		}
	}
	
	public void doYourThing(GameContainer gc){
		for(objekt o : getEnvironment()){
			if(o instanceof mob){
				((mob) o).doYourThing(gc, this);
			}
		}
	}
}

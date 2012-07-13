package entities;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;

public class umgebung {

	private ArrayList<objekt> objekte;

	public umgebung(){
		objekte = new ArrayList<objekt>();
	}
	
	public ArrayList<objekt> getUmgebung(){
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
}

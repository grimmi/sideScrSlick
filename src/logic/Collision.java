package logic;

import java.util.ArrayList;

import util.co;

import entities.objekt;
import entities.environment;

public class Collision {
	
	public ArrayList<String> collisionObjektEnvironment(objekt m, environment u){
		ArrayList<String> collisions = new ArrayList<String>();
		for(objekt o : u.getEnvironment()){
			ArrayList<String> oCollision = m.intersects(o);
			for(String s : oCollision){
					collisions.add(s);
			}
		}
		return collisions;
	}
}

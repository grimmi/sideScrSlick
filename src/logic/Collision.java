package logic;

import java.util.ArrayList;

import util.co;

import entities.objekt;
import entities.environment;

public class Collision {
	
	public ArrayList<String> collisionObjektEnvironment(objekt m, environment u){
		ArrayList<String> collisions = new ArrayList<String>();
		if(!u.getEnvironment().isEmpty()){
			for(objekt o : u.getEnvironment()){
				if(m.getX() < o.getX() && m.getX()+m.getWidth() > o.getX()){
					if((m.getY() <= o.getY()+o.getHeight() && m.getY() >= o.getY()) || (m.getY() <= o.getY() && m.getY()+m.getHeight() >= o.getY())){
						if(!collisions.contains(co.COLLISION_RIGHT)){
							collisions.add(co.COLLISION_RIGHT);
						}
					}
				}
				if(m.getX() < o.getX()+o.getWidth() && m.getX() > o.getX()){
					if((m.getY() <= o.getY()+o.getHeight() && m.getY() >= o.getY()) || (m.getY() <= o.getY() && m.getY()+m.getHeight() >= o.getY())){
						if(!collisions.contains(co.COLLISION_LEFT)){
							collisions.add(co.COLLISION_LEFT);
						}
					}
				}
			}
		}
		return collisions;
	}
}

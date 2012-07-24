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
				if(checkRight(m,o)){
					if(checkUp(m,o) || checkDown(m,o)){
						if(!collisions.contains(co.COLLISION_RIGHT)){
							collisions.add(co.COLLISION_RIGHT);
						}
					}
				}
				if(checkLeft(m,o)){
					if(checkUp(m,o) || checkDown(m,o)){
						if(!collisions.contains(co.COLLISION_LEFT)){
							collisions.add(co.COLLISION_LEFT);
						}
					}
				}
				if(checkDown(m,o)){
					if(checkLeft(m,o) || checkRight(m,o)){
						if(!collisions.contains(co.COLLISION_DOWN)){
							collisions.add(co.COLLISION_DOWN);
						}
					}
				}
				if(checkUp(m,o)){
					if(checkLeft(m,o) || checkRight(m,o)){
						if(!collisions.contains(co.COLLISION_UP)){
							collisions.add(co.COLLISION_UP);
						}
					}
				}
			}
		}
		return collisions;
	}
	
	public boolean checkRight(objekt m, objekt o){
		if(m.getX() < o.getX() && m.getX()+m.getWidth() > o.getX()){
			return true;
		}
		else return false;
	}
	
	public boolean checkLeft(objekt m, objekt o){
		if(m.getX() < o.getX()+o.getWidth() && m.getX() > o.getX()){
			return true;
		}
		else return false;
	}
	
	public boolean checkUp(objekt m, objekt o){
		if(m.getY() <= o.getY() && m.getY() >= o.getY()){
			return true;
		}
		else return false;
	}
	
	public boolean checkDown(objekt m, objekt o){
		if(m.getY()+m.getHeight() <= o.getY()+o.getHeight() && m.getY()+m.getHeight() >= o.getY()){
			return true;
		}
		else return false;
	}
}

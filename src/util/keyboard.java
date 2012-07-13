package util;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class keyboard {

	private static Input in;
	private static int key;
	private static String keyName;
	
	public keyboard(GameContainer gc){
		in = gc.getInput();
		setKey(148);		
	}
	
	public boolean isAnyKey(){
		for(int i = 0; i < 224; i++){
			if(in.isKeyPressed(i)){
				return true;
			}
		}
		return false;
	}
	
	public void keyPressed(){
		for(int i = 0; i < 224; i++){
			if(in.isKeyPressed(i)){
				key = i;
				keyName = in.getKeyName(key);
			}
		}
	}
	
	public int getKey(){
		return key;
	}
	
	public void setKey(int k){
		key = k;
	}
	
	public String getKeyName(){
		return in.getKeyName(getKey());
	}
	
	public void setKeyName(String s){
		keyName = s;
	}
	
	public void update(){
		keyPressed();
		isAnyKey();
	}

}

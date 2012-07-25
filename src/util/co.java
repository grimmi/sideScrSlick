package util;

import org.newdawn.slick.Input;

public class co {

	public static int WINDOW_X = 1024;
	public static int WINDOW_Y = 768;
	
	public static int MOVE_LEFT = Input.KEY_LEFT;
	public static int MOVE_RIGHT = Input.KEY_RIGHT;
	public static int MOVE_UP = Input.KEY_UP;
	public static int MOVE_DOWN = Input.KEY_DOWN;
	public static int MOVE_JUMP = Input.KEY_SPACE;

	
	/*
	 * 	8 1 2 
	 *  7 0 3
	 *  6 5 4
	 */
	public static int DIR_UP = 1;
	public static int DIR_UP_RIGHT = 2;	
	public static int DIR_RIGHT = 3;
	public static int DIR_DOWN_RIGHT = 4;
	public static int DIR_DOWN = 5;
	public static int DIR_DOWN_LEFT = 6;
	public static int DIR_LEFT = 7;
	public static int DIR_UP_LEFT = 8;
	public static int DIR_NODIR = 0;
	
	public static String COLLISION_UP = "up";
	public static String COLLISION_DOWN = "down";
	public static String COLLISION_LEFT = "left";
	public static String COLLISION_RIGHT = "right";
	public static String COLLISION_NOCOLLISION = "none";
}

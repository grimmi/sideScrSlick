package util;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Font;
import org.newdawn.slick.SlickException;

public class fonts {

	public static Font dadha;
	public static Font cNew;
	
	public fonts() throws SlickException{
		dadha = new AngelCodeFont("/res/font/dadha.fnt","/res/font/dadha_00.png");
		cNew = new AngelCodeFont("/res/font/courierNew.fnt","/res/font/courierNew_0.png");
	}

}

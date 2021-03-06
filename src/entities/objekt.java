package entities;

import java.util.ArrayList;
import java.util.List;

import logic.Collision;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import util.co;
import util.images;

public class objekt {

	private float x,y;
	private float renderX, renderY;
	private float width;
	private float height;
	
	private images i;
	private Image image;
	
	private Collision coll;
	private ArrayList<String> environmentCollisionList;
	private long lastCollision;
	
	private environment env;
	
	public objekt(environment u) throws SlickException{
		x = 0;
		y = 0;
		setRenderX(0);
		setRenderY(0);
		setLastCollision(System.currentTimeMillis());
		setEnvironment(u);
		i = new images();
		setImage(i.blueBlock);
	}
	
	public objekt(float x, float y, environment u) throws SlickException{
		this(u);
		setX(x);
		setY(y);
	}
	
	private void setLastCollision(long newTime) {
		lastCollision = newTime;		
	}
	
	private long getLastCollision(){
		return lastCollision;
	}

	public void setX(float x){
		ArrayList<String> collisions = new ArrayList<String>(getEnvironmentCollisionList(getEnvironment()));
		if(x < getX()){
			if(collisions.contains(co.COLLISION_LEFT)){
				this.x = getX();
			}
			else{
				this.x = x;
			}
		}
		else if(x > getX()){
			if(collisions.contains(co.COLLISION_RIGHT)){
				this.x = getX();
			}
			else{
				this.x = x;
			}
		}
		else{
			this.x = x;
		}
	}
	
	public float getX(){
		return x;
	}
	
	public void setY(float y){
		ArrayList<String> collisions = new ArrayList<String>(getEnvironmentCollisionList(getEnvironment()));
		if(y < getY()){
			if(collisions.contains(co.COLLISION_UP)){
				this.y = getY();
			}
			else{
				this.y = y;
			}
		}
		else if(y > getY()){
			if(collisions.contains(co.COLLISION_DOWN)){
				this.y = getY();
			}
			else{
				this.y = y;
			}
		}
		else{
			this.y = y;
		}
	}
	
	public float getY(){
		return y;
	}
	
	public void setPos(float x, float y){
		setX(x);
		setY(y);
	}
	
	public float[] getPos(){
		float[] pos = {x,y};
		return pos;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	public void draw(Graphics g){
		g.drawImage(getImage(),x,y);
	}

	public float getWidth() {
		if(getImage() != null){
			return getImage().getWidth();
		}
		else{
			return -1f;
		}
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		if(getImage() != null){
			return getImage().getHeight();
		}
		else{
			return -1f;
		}
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getRenderX() {
		return renderX;
	}

	public void setRenderX(float renderX) {
		this.renderX = renderX;
	}

	public float getRenderY() {
		return renderY;
	}

	public void setRenderY(float renderY) {
		this.renderY = renderY;
	}
	
	public List<String> getEnvironmentCollisionList(environment u){
		long akt_Zeit = System.currentTimeMillis();
		if((akt_Zeit - getLastCollision()) > 100 || environmentCollisionList == null || environmentCollisionList.isEmpty()){
			if(coll == null){
				coll = new Collision();
			}
			environmentCollisionList = coll.collisionObjektEnvironment(this, u);
		}
		return environmentCollisionList;
	}
	
	public environment getEnvironment(){
		return env;
	}
	
	public void setEnvironment(environment u){
		env = u;
	}
	
	public ArrayList<String> intersects(objekt o){
		ArrayList<String> intersects = new ArrayList<String>();
		if(this != o){
			float s = 0f;
			if(this instanceof mob){
				mob t = (mob)this;
				s = t.getSpeed();
			}
			float x = getX();
			float y = getY();
			float w = getWidth();
			float h = getHeight();
			float xW = x+w;
			float yH = y+h;
			float oX = o.getX();
			float oY = o.getY();
			float oW = o.getWidth();
			float oH = o.getHeight();
			float oXW = oX+oW;
			float oYH = oY+oH;
			
			if((x < oX && xW+s > oX) && (((y > oY && y < oYH) || (yH > oY && yH < oYH)) || (y == oY && yH == oYH))){
				intersects.add(co.COLLISION_RIGHT);
			}
			if((xW > oXW && x-s < oXW) && (((y > oY && y < oYH) || (yH > oY && yH < oYH)) || (y == oY && yH == oYH))){
				intersects.add(co.COLLISION_LEFT);
			}
			
			if((yH > oY-s && yH < oYH) && (((x < oXW && x > oX) || (xW < oXW && xW > oX)) || (x == oX && xW == oXW))){
				intersects.add(co.COLLISION_DOWN);
			}
			
			if((y < oYH+s && yH > oY) && (((x < oXW && x > oX) || (xW < oXW && xW > oX)) || (x == oX && xW == oXW))){
				intersects.add(co.COLLISION_UP);
			}
		}
		return intersects;
	}
	
}

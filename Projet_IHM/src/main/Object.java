package main;

import java.awt.Image;

public abstract class Object extends Thread {

	protected Game game;
	protected float posX, posY;
	protected boolean exists;
	
	public Object(float posX, float posY, Game game) {
		this.posX = posX;
		this.posY = posY;
		this.exists = true;
		this.game = game;
	}
	
	public abstract void run();
	
	public abstract Image getImage();
	
	public int getX() {
		return (int) this.posX;
	}
	
	public int getY() {
		return (int) this.posY;
	}
	
	public void stopExisting() {
		this.exists = false;
	}
}

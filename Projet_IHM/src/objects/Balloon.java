package objects;
import java.awt.Image;

import main.*;
import main.Object;

public class Balloon extends Object {

	private float accX,accY;
	private int state;
	
	public Balloon(float posX, float posY, Game game) {
		super(posX,posY,game);
		this.accX = 0;
		this.accY = 0;
		this.state = 0;
	}

	@Override
	public void run() {
		while (exists) {
			/** Natural speed change **/
			accY = -1;
			/** Check collision **/
			for (Object a : game.getObjects()) {
				// If needed, change speed, trigger an effect
				if (state == 0) {
					if (a instanceof Scissors) {
						boolean yPos = ((a.getY()>=this.getY()+45 && a.getY()<=this.getY()+48) || (a.getY()>=this.getY()-36 && a.getY()<=this.getY()-33));
						if (((Scissors) a).getBladeState() == 0) {
							boolean xPos = (((a.getX()<=this.getX()+25 && a.getX()>=this.getX()-25 && ((Scissors) a).getOrientation()==0) 
												|| (a.getX()<=this.getX() && a.getX()>=this.getX()-50 && ((Scissors) a).getOrientation()==1)));
							if (xPos && yPos && Math.abs(accY) > Math.abs(accX)) {
								((Scissors) a).activate();
								this.accY = 0;
							}
						} else {
							boolean xPos = (a.getX()>=this.getX()-8 && a.getX()<=this.getX()+8);
							if (xPos && yPos) {
								accY = 0;
							}
						}
					}
				}
			}
			/** Move **/
			posX += accX;
			posY += accY;
			
			/**Set the sleep as needed **/
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		game.getObjects().remove(this);
	}

	@Override
	public Image getImage() {
		if (state == 0) {
			return Frame.resource.getSubimage(12,95,32,47);
		} else {
			return Frame.resource.getSubimage(12,95,32,47); //ANIM TODO
		}
	}
	
	/** Interactions **/
	

}
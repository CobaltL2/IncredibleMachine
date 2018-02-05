package objects;

import java.awt.Image;
import main.Object;
import main.*;

public class Scissors extends Object{
	
	private int state;
	private int orientation;
	
	public Scissors(float posX, float posY, int orientation, Game game) {
		super(posX,posY,game);
		this.orientation = orientation; // 0 = BLADE RIGHT, 1 = BLADE LEFT
		this.state = 0; // 0 = OPEN, 1 = ACTIVATED, 2 = USED
	}

	@Override
	public void run() {
		while (exists) {
			
			/** Check collision **/
			if (state == 1) {
				for (Object a : game.getObjects()) {
					// Si y a une corde, on la coupe
				}
				state = 2;
			}
			
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
			return Frame.resource.getSubimage(748,618,45,34);
		} else {
			return Frame.resource.getSubimage(797,618,45,34);
		}
	}
	
	public int getOrientation() {
		return orientation;
	}
	
	public int getBladeState() {
		return state;
	}
	
	/** Interactions **/
	
	public void activate() {
		if (state == 0) {
			state = 1;
		}
	}
	
}

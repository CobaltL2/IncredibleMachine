package main;

import java.awt.Graphics;

import javax.swing.JPanel;

public class GameWindow extends JPanel {

	private Game game;
	private Frame frame;
	
	public GameWindow(Game game,Frame frame) {
		this.game = game;
		this.frame = frame;
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        /** Draw a sky **/
        for (Object a : game.getObjects()) {
        	g.drawImage(a.getImage(), a.getX(), a.getY(), null);
        }
	}
	
}

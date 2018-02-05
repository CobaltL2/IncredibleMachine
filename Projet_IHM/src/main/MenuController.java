package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {

	Frame frame;
	
	public MenuController(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Play")) {
			frame.editState(1);
			frame.update();
		}
		if (e.getActionCommand().equals("Exit")) {
			System.exit(0);
		}
		
	}
	
	

}

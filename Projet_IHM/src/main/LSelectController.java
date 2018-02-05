package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LSelectController implements ActionListener {

	private Frame frame;
	
	public LSelectController(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String a = e.getActionCommand().replaceAll("Level ","");
		frame.editState(2);
		frame.startLevel(Integer.parseInt(a));
		frame.update();
	}

}

package controller.lightweightController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainAppFrame;

/**
 * 
 * A light weight controller which is responsible for closing main frame
 * 
 * 
 * @author Tuan Vu
 */

public class InitiateExitMenu implements ActionListener {

	private MainAppFrame frame;

	public InitiateExitMenu(MainAppFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();

	}

}

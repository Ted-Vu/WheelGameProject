package controller.lightweightController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainAppFrame;
import view.CustomDialog.AddPlayerDialog;

/**
 * 
 * A light weight controller which is responsible for invoking addPlayerDialog()
 * 
 * 
 * @author Tuan Vu
 */

public class InitiateAddPlayerDialogActionListener implements ActionListener {

	private MainAppFrame frame;

	public InitiateAddPlayerDialogActionListener(MainAppFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		new AddPlayerDialog(frame);

	}

}

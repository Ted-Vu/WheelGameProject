package controller.lightweightController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainAppFrame;
import view.CustomDialog.OddsTableDialog;

/**
 * 
 * A light weight controller which is responsible for invoking oddDialog()
 * 
 * 
 * @author Tuan Vu
 */

public class InitiateOddDialog implements ActionListener {

	private MainAppFrame frame;

	public InitiateOddDialog(MainAppFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		new OddsTableDialog(frame);
	}

}

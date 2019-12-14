package controller.lightweightController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainAppFrame;
import view.CustomDialog.GameRuleDialog;

/**
 * 
 * A light weight controller which is responsible for invoking gameRuleDialog()
 * 
 * 
 * @author Tuan Vu
 */

public class InitiateGameRuleMenu implements ActionListener {

	private MainAppFrame frame;

	public InitiateGameRuleMenu(MainAppFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		new GameRuleDialog(frame);
	}

}

package controller.lightweightController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainAppFrame;
import model.interfaces.GameEngine;
import view.CustomDialog.PlaceBetDialog;
import view.MessageDialog.NotificationDialogForPlacingBet;

/**
 * 
 * A light weight controller which is responsible for invking placeBetDialog()
 * 
 * 
 * @author Tuan Vu
 */

public class InitiatePlaceBetDialogActionListener implements ActionListener {

	private GameEngine gameEngineImpl;
	private MainAppFrame frame;
	private PlaceBetDialog placeBetDialog;

	private NotificationDialogForPlacingBet notification;

	public InitiatePlaceBetDialogActionListener(MainAppFrame frame) {
		gameEngineImpl = frame.getGameEngineImpl();
		this.frame = frame;
		notification = new NotificationDialogForPlacingBet(frame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// if there exists player then able to invoke the place bet dialog
		if (gameEngineImpl.getAllPlayers().isEmpty() == false) {

			placeBetDialog = new PlaceBetDialog(frame, true);
			placeBetDialog.updateListOfPlayer();

		} else {
			notification.showMessageNoPlayerToPlaceBet();
		}
	}

}

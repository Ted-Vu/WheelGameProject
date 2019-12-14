package controller.heavyweightController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainAppFrame;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.CustomDialog.AddPlayerDialog;
import view.MessageDialog.NotificationDialogForAddingPlayer;
import view.OperationFrame.RemovePanel;
import view.WheelFrame.SummaryPanel;

/**
 * 
 * A heavy weight controller which is responsible for notifying model
 * and updating views due to model changed when adding players
 *
 * @author Tuan Vu
 */

public class AddPlayerActionListener implements ActionListener {

	private GameEngine gameEngineImpl;

	private SummaryPanel summaryPanel;
	private RemovePanel removePanel;
	private AddPlayerDialog addPlayerDialog;

	private NotificationDialogForAddingPlayer notification;

	public AddPlayerActionListener(MainAppFrame frame, AddPlayerDialog addPlayerDialog) {

		this.addPlayerDialog = addPlayerDialog;
		gameEngineImpl = frame.getGameEngineImpl();
		summaryPanel = frame.getSummaryPanel();
		removePanel = frame.getOperationPanel().getRemovePanel();
		notification = new NotificationDialogForAddingPlayer(frame);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String playerNameStr = addPlayerDialog.getNameTextField().getText();
		String playerIDStr = addPlayerDialog.getPlayerIDField().getText();
		String initialPointsStr = addPlayerDialog.getPlayerInitialPointsField().getText();
		
		//exception is thrown when user does not enter an integer value for ID or point
		try {
			int ID = Integer.parseInt(playerIDStr);
			int point = Integer.parseInt(initialPointsStr);

			if (ID >= 0 && point >= 0) {
				Player player = new SimplePlayer(playerIDStr, playerNameStr, point);
				gameEngineImpl.addPlayer(player);

				summaryPanel.updateSummaryPanel();
				removePanel.updateListOfPlayer();
				notification.showMessageWhenAddSuccessful();
				addPlayerDialog.dispose();

			} else {
				if (ID < 0) {
					notification.showMessageCheckID();
				} else {
					notification.showMessageCheckPointInput();
				}
			}
		} catch (NumberFormatException ex) {
			notification.showMessageNotANumericValue();
		}

	}

}

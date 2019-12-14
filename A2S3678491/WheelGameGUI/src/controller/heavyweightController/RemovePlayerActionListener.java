package controller.heavyweightController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainAppFrame;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MessageDialog.NotificationDialogForRemovingPlayer;
import view.OperationFrame.RemovePanel;
import view.WheelFrame.SpinToolbar;
import view.WheelFrame.SummaryPanel;

/**
 * 
 * A heavy weight controller which is responsible for notifying model
 * and updating views due to model changed when removing players
 * 
 * @author Tuan Vu
 */

public class RemovePlayerActionListener implements ActionListener {

	private GameEngine gameEngineImpl;

	private RemovePanel removePanel;
	private SummaryPanel summaryPanel;
	private SpinToolbar spinToolbar;

	private NotificationDialogForRemovingPlayer notification;

	public RemovePlayerActionListener(MainAppFrame frame, RemovePanel removePanel) {

		this.removePanel = removePanel;
		summaryPanel = frame.getSummaryPanel();
		spinToolbar = frame.getSpinToolbar();
		gameEngineImpl = frame.getGameEngineImpl();
		notification = new NotificationDialogForRemovingPlayer(frame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//if there exists player then able to remove
		if (!gameEngineImpl.getAllPlayers().isEmpty()) {
			for (Player player : gameEngineImpl.getAllPlayers()) {
				if (player.getPlayerId().equals(removePanel.getListOfPlayer().getSelectedItem().toString())) {
					gameEngineImpl.removePlayer(player);
					summaryPanel.updateSummaryPanel();
					spinToolbar.updateSpinMenu();
					removePanel.updateListOfPlayer();
					notification.showMessageRemovePlayerSuccessful();
					break;
				}
			}

		} else {
			notification.showMessageNoPlayerToRemove();
		}
	}

}

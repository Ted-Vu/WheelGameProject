package controller.heavyweightController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainAppFrame;
import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.CustomDialog.PlaceBetDialog;
import view.MessageDialog.NotificationDialogForPlacingBet;
import view.WheelFrame.SpinToolbar;
import view.WheelFrame.StatusBar;
import view.WheelFrame.SummaryPanel;

/**
 * 
 * A heavy weight controller which is responsible for notifying model and
 * updating views due to model changed when placing bets . Input validation is
 * handled by using exception handling and boolean condition return from
 * placeBet() of gameEngineImpl
 * 
 * @author Tuan Vu
 */

public class PlaceBetActionListener implements ActionListener {

	private GameEngine gameEngineImpl;

	private StatusBar statusBar;
	private PlaceBetDialog placeBetDialog;
	private SummaryPanel summaryPanel;
	private SpinToolbar spinToolbar;

	private NotificationDialogForPlacingBet notification;

	public PlaceBetActionListener(MainAppFrame frame, PlaceBetDialog placeBetDialog) {

		statusBar = frame.getStatusBar();
		gameEngineImpl = frame.getGameEngineImpl();
		summaryPanel = frame.getSummaryPanel();
		spinToolbar = frame.getSpinToolbar();
		this.placeBetDialog = placeBetDialog;
		notification = new NotificationDialogForPlacingBet(frame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String playerID = placeBetDialog.getListOfPlayerID().getSelectedItem().toString();
		String betType = placeBetDialog.getListOfBetType().getSelectedValue().toString();
		String bet = placeBetDialog.getBetField().getText();
		boolean setBetValid = false;

		// exception is thrown if user does not enters an integer value
		try {
			int betInt = Integer.parseInt(bet);

			for (Player player : gameEngineImpl.getAllPlayers()) {
				if (player.getPlayerId().equals(playerID)) {

					if (player.setBet(betInt)) {
						if (betType.equals("RED")) {
							player.setBetType(BetType.RED);
						} else if (betType.equals("BLACK")) {
							player.setBetType(BetType.BLACK);
						} else if (betType.equals("ZEROS")) {
							player.setBetType(BetType.ZEROS);
						}
						setBetValid = true;
						break;
					}
				}
			}
			if (setBetValid) {
				int countNumberOfPlayerPlaceBet = 0;

				summaryPanel.updateSummaryPanel();
				spinToolbar.updateSpinMenu();
				statusBar.updateStatusBarAfterPlaceBet(spinToolbar.getListOfPlayer().getItemCount());

				notification.showMessageWhenPlaceSuccessful();
				placeBetDialog.dispose();
				for (Player player : gameEngineImpl.getAllPlayers()) {
					if (player.getBet() != 0) {
						countNumberOfPlayerPlaceBet++;
					}
				}

				// automatic spin triggered here once all players have placed their bet
				if (gameEngineImpl.getAllPlayers().size() == countNumberOfPlayerPlaceBet) {
					placeBetDialog.dispose();
					spinToolbar.getSpinButton().doClick();
				}

			} else {
				notification.showMessageInvalidBetInput(betInt);
			}
		} catch (NumberFormatException ex) {
			notification.showMessageNotANumericValueForBet();
		}

	}

}

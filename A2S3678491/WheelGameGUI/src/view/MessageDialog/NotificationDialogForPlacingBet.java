package view.MessageDialog;

import javax.swing.JOptionPane;

import main.MainAppFrame;

/**
 * 
 * This class will be added to the PlaceBetActionListener to display
 * notification message
 *
 *
 * @author Tuan Vu
 */

public class NotificationDialogForPlacingBet {

	private MainAppFrame frame;

	public NotificationDialogForPlacingBet(MainAppFrame frame) {
		this.frame = frame;
	}

	public void showMessageWhenPlaceSuccessful() {
		JOptionPane.showMessageDialog(frame, "PLACE BET SUCCESSFUL", "PLACE BET NOTIFICATION",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void showMessageInvalidBetInput(int bet) {
		if (bet == 0) {
			JOptionPane.showMessageDialog(frame, "BET MUST BE GREATER THAN 0 ", "PLACE BET NOTIFICATION",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(frame, "BET MUST BE SMALLER THAN OR EQUAL TO YOUR CURRENT POINT BALANCE",
					"PLACE BET NOTIFICATION", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void showMessageNotANumericValueForBet() {
		JOptionPane.showMessageDialog(frame, "YOUR BET INPUT IS NOT A NUMERIC VALUE", "PLACE BET NOTIFICATION",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void showMessageNoPlayerToPlaceBet() {
		JOptionPane.showMessageDialog(frame, "YOU HAVE NOT ADDED ANY PLAYER YET", "PLACE BET NOTIFICATION",
				JOptionPane.INFORMATION_MESSAGE);
	}
}

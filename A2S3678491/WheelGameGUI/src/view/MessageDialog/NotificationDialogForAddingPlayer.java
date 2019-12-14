package view.MessageDialog;

import javax.swing.JOptionPane;

import main.MainAppFrame;

/**
 * 
 * This class will be added to the AddPlayerActionListener to display
 * notification message
 *
 *
 * @author Tuan Vu
 */

public class NotificationDialogForAddingPlayer {

	private MainAppFrame frame;

	public NotificationDialogForAddingPlayer(MainAppFrame frame) {
		this.frame = frame;
	}

	public void showMessageWhenAddSuccessful() {
		JOptionPane.showMessageDialog(frame, "ADD PLAYER SUCCESSFUL", "ADD PLAYER NOTIFICATION",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void showMessageCheckID() {
		JOptionPane.showMessageDialog(frame, "PLEASE CHECK YOUR ID", "ADD PLAYER NOTIFICATION",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void showMessageCheckPointInput() {
		JOptionPane.showMessageDialog(frame, "PLEASE CHECK YOUR POINT INPUT", "ADD PLAYER NOTIFICATION",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void showMessageNotANumericValue() {
		JOptionPane.showMessageDialog(frame, "PLEASE CHECK YOUR FORMAT FOR INPUT", "ADD PLAYER NOTIFICATION",
				JOptionPane.INFORMATION_MESSAGE);
	}
}

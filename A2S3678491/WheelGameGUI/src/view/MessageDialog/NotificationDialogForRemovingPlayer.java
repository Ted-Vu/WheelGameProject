package view.MessageDialog;

import javax.swing.JOptionPane;

import main.MainAppFrame;

/**
 * 
 * This class will be added to the RemovePlayerActionListener to display
 * notification message
 *
 *
 * @author Tuan Vu
 */

public class NotificationDialogForRemovingPlayer {

	private MainAppFrame frame;

	public NotificationDialogForRemovingPlayer(MainAppFrame frame) {
		this.frame = frame;
	}

	public void showMessageRemovePlayerSuccessful() {
		JOptionPane.showMessageDialog(frame, "REMOVE PLAYER SUCCESSFUL", "REMOVE PLAYER NOTIFICATION",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void showMessageNoPlayerToRemove() {
		JOptionPane.showMessageDialog(frame, "NO PLAYER ADDED TO REMOVE", "REMOVE PLAYER NOTIFICATION",
				JOptionPane.INFORMATION_MESSAGE);
	}
}

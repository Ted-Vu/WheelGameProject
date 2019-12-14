package view.MessageDialog;

import javax.swing.JOptionPane;

import main.MainAppFrame;

/**
 * 
 * This class will be added to the SpinActionListener to display notification
 * message
 *
 *
 * @author Tuan Vu
 */

public class NotificationDialogForSpinning {

	private MainAppFrame frame;

	public NotificationDialogForSpinning(MainAppFrame frame) {
		this.frame = frame;
	}

	public void showMessageWhenNoPlayerJoining() {
		JOptionPane.showMessageDialog(frame, "NO PLAYER JOINING GAME YET", "SPINNING WHEEL NOTIFICATION",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void showMessageWhenNoBetType(int countPlayerNoBetType) {
		JOptionPane.showMessageDialog(frame,
				"THERE ARE " + countPlayerNoBetType + " PLAYERS THAT DO NOT CHOOSE BET TYPE",
				"SPINNING WHEEL NOTIFICATION", JOptionPane.INFORMATION_MESSAGE);
	}
}

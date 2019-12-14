package view.WheelFrame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.MainAppFrame;

/**
 * A view class which is always visible to show game status including number of
 * players participating in this round and status of wheel
 * 
 * 
 * @author Tuan Vu
 */

@SuppressWarnings("serial")
public class StatusBar extends JPanel {

	private JLabel numberOfPlayer;
	private JLabel wheelStatus;

	public StatusBar(MainAppFrame frame) {
		this.setLayout(new GridLayout(1, 2));

		numberOfPlayer = new JLabel("Number of Player place bet in this round:        0", FlowLayout.RIGHT);

		wheelStatus = new JLabel("Wheel Status:        Waiting for player to place bet", FlowLayout.RIGHT);
		this.add(numberOfPlayer);
		this.add(wheelStatus);
		numberOfPlayer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		wheelStatus.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	}

	public void updateStatusBarAfterSpin() {
		numberOfPlayer.setText("Number Of Player place bet in this round:       0");
		wheelStatus.setText("Wheel Status:       Waiting for players to place bet");
	}

	public void updateStatusBarDuringSpin(int listOfPlayerPlaceBet) {
		numberOfPlayer.setText("Number Of Player place bet in this round:       " + listOfPlayerPlaceBet);
		wheelStatus.setText("Wheel Status:       Spinning...");
	}

	public void updateStatusBarAfterPlaceBet(int listOfPlayerPlaceBet) {
		numberOfPlayer.setText("Number Of Player place bet in this round:       " + listOfPlayerPlaceBet);
	}

}

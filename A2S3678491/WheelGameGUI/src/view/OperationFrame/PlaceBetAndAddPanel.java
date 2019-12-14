package view.OperationFrame;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.lightweightController.InitiateAddPlayerDialogActionListener;
import controller.lightweightController.InitiatePlaceBetDialogActionListener;
import main.MainAppFrame;

/**
 * 
 * A view class which contains two buttons to invoke dialogs in order to add
 * players or place bet
 * 
 * 
 * @author Tuan Vu
 */

@SuppressWarnings("serial")
public class PlaceBetAndAddPanel extends JPanel {

	private JButton addButton;
	private JButton placeBetButton;

	public PlaceBetAndAddPanel(MainAppFrame Frame) {

		this.setLayout(new FlowLayout());

		addButton = new JButton("ADD PLAYER");
		addButton.addActionListener(new InitiateAddPlayerDialogActionListener(Frame));

		placeBetButton = new JButton("PLACE BET");
		placeBetButton.addActionListener(new InitiatePlaceBetDialogActionListener(Frame));

		this.add(addButton);
		this.add(placeBetButton);

	}

	public void updateButtonAfterSpin() {
		addButton.setEnabled(true);
		placeBetButton.setEnabled(true);
	}

	public void updateButtonDuringspin() {
		addButton.setEnabled(false);
		placeBetButton.setEnabled(false);
	}
}

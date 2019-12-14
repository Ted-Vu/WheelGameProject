package view.OperationFrame;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.heavyweightController.RemovePlayerActionListener;
import main.MainAppFrame;
import model.interfaces.GameEngine;
import model.interfaces.Player;

/**
 * 
 * A view class which is always visible to remove players from game
 * 
 * 
 * @author Tuan Vu
 */

@SuppressWarnings("serial")
public class RemovePanel extends JPanel {

	private static final int WIDTH_LISTOFPLAYER = 110;
	private static final int HEIGHT_LISTOFPLAYER = 20;

	private GameEngine gameEngineImpl;

	private JLabel playerIDLabel;
	private JComboBox<String> listOfPlayer;
	private JButton removeButton;

	public RemovePanel(MainAppFrame frame) {
		gameEngineImpl = frame.getGameEngineImpl();

		playerIDLabel = new JLabel("Player ID: ");

		listOfPlayer = new JComboBox<>();

		listOfPlayer.setPreferredSize(new Dimension(WIDTH_LISTOFPLAYER, HEIGHT_LISTOFPLAYER));

		removeButton = new JButton("REMOVE");
		removeButton.addActionListener(new RemovePlayerActionListener(frame, this));

		Border innerBorder = BorderFactory.createTitledBorder("REMOVE PLAYER");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

		this.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		setLayout(new GridBagLayout());

		GridBagConstraints gridBagConstraints = new GridBagConstraints();

		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 1;

		// First row
		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = GridBagConstraints.LINE_END;
		gridBagConstraints.fill = GridBagConstraints.NONE;
		gridBagConstraints.insets = new Insets(0, 0, 0, 5);
		add(playerIDLabel, gridBagConstraints);

		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = GridBagConstraints.LINE_START;
		gridBagConstraints.insets = new Insets(0, 0, 0, 0);
		add(listOfPlayer, gridBagConstraints);

		// second row
		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 2;
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		add(removeButton, gridBagConstraints);

	}

	public JComboBox<String> getListOfPlayer() {
		return listOfPlayer;
	}

	public void updateListOfPlayer() {
		listOfPlayer.removeAllItems();
		for (Player player : gameEngineImpl.getAllPlayers()) {
			listOfPlayer.addItem(player.getPlayerId());
		}
	}

	public void updateRemoveButtonAfterSpin() {
		removeButton.setEnabled(true);
	}

	public void updateRemoveButtonDuringSpin() {
		removeButton.setEnabled(false);
	}

}

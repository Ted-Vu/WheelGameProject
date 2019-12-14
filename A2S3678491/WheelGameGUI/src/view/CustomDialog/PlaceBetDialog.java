package view.CustomDialog;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import controller.heavyweightController.PlaceBetActionListener;
import main.MainAppFrame;
import model.interfaces.GameEngine;
import model.interfaces.Player;

/**
 * 
 * A view class invoked when placing bets for players
 * 
 * 
 * @author Tuan Vu
 */

@SuppressWarnings("serial")
public class PlaceBetDialog extends JDialog {

	private static final int X_COORDINATE_OF_FRAME = 450;
	private static final int Y_COORDINATE_OF_FRAME = 250;
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 200;
	private static final int WIDTH_LIST_OF_PLAYER = 110;
	private static final int HEIGHT_LIST_OF_PLAYER = 20;
	private static final int WIDTH_BET_TYPE_LIST = 110;
	private static final int HEIGHT_BET_TYPE_LIST = 66;
	private static final int WIDTH_OF_TEXT = 12;

	private JLabel nameLabel;
	private JLabel playerIDLabel;
	private JLabel bettypeLabel;
	private JTextField betField;

	private JComboBox<String> listOfPlayer;
	private DefaultListModel<String> betTypeModel;
	private JList<String> betTypeList;

	private JButton placeBetButton;

	private GameEngine ge;

	public PlaceBetDialog(MainAppFrame mainFrame, boolean modal) {

		super(mainFrame, "PLACE BET", modal);

		ge = mainFrame.getGameEngineImpl();

		nameLabel = new JLabel("Bet: ");
		playerIDLabel = new JLabel("Player ID: ");
		betField = new JTextField(WIDTH_OF_TEXT);

		// list of player will display all player when listening to
		// model changed
		listOfPlayer = new JComboBox<String>();
		updateListOfPlayer();
		listOfPlayer.setPreferredSize(new Dimension(WIDTH_LIST_OF_PLAYER, HEIGHT_LIST_OF_PLAYER));

		bettypeLabel = new JLabel("Bet Type: ");

		betTypeModel = new DefaultListModel<>();
		betTypeModel.addElement("RED");
		betTypeModel.addElement("BLACK");
		betTypeModel.addElement("ZEROS");

		betTypeList = new JList<>();
		betTypeList.setPreferredSize(new Dimension(WIDTH_BET_TYPE_LIST, HEIGHT_BET_TYPE_LIST));
		betTypeList.setBorder(BorderFactory.createEtchedBorder());
		betTypeList.setModel(betTypeModel);
		betTypeList.setSelectedIndex(0);

		placeBetButton = new JButton("PLACE");
		placeBetButton.addActionListener(new PlaceBetActionListener(mainFrame, this));

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
		add(nameLabel, gridBagConstraints);

		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = GridBagConstraints.LINE_START;
		gridBagConstraints.insets = new Insets(0, 0, 0, 0);
		add(betField, gridBagConstraints);

		// Second row
		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = GridBagConstraints.LINE_END;
		gridBagConstraints.insets = new Insets(0, 0, 0, 5);
		add(playerIDLabel, gridBagConstraints);

		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = GridBagConstraints.LINE_START;
		gridBagConstraints.insets = new Insets(0, 0, 0, 0);
		add(listOfPlayer, gridBagConstraints);

		// Third row
		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 0.2;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = GridBagConstraints.LINE_END;
		gridBagConstraints.insets = new Insets(0, 0, 0, 5);
		add(bettypeLabel, gridBagConstraints);

		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 0.2;
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		add(betTypeList, gridBagConstraints);

		// Fourth row
		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 2;
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		add(placeBetButton, gridBagConstraints);

		this.setBounds(X_COORDINATE_OF_FRAME, Y_COORDINATE_OF_FRAME, FRAME_WIDTH, FRAME_HEIGHT);
		this.setVisible(true);

	}

	public JComboBox<String> getListOfPlayerID() {
		return listOfPlayer;
	}

	public JTextField getBetField() {
		return betField;
	}

	public JList<String> getListOfBetType() {
		return betTypeList;
	}

	public void updateListOfPlayer() {
		if (listOfPlayer.getItemCount() > 0) {
			listOfPlayer.removeAllItems();
		}

		for (Player player : ge.getAllPlayers()) {
			listOfPlayer.addItem(player.getPlayerId());
		}
	}

}

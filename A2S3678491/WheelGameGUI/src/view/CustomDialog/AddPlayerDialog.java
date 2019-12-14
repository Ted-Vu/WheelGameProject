package view.CustomDialog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.heavyweightController.AddPlayerActionListener;
import main.MainAppFrame;

/**
 * 
 * A view class invoked when adding players
 * 
 * 
 * @author Tuan Vu
 */

@SuppressWarnings("serial")
public class AddPlayerDialog extends JDialog {

	private static final int X_COORDINATE_OF_FRAME = 450;
	private static final int Y_COORDINATE_OF_FRAME = 250;
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 200;

	private JLabel playerIDLabel;
	private JLabel playerNameLabel;
	private JLabel initialPointsLabel;

	private JTextField nameTextField;
	private JTextField playerIDField;
	private JTextField initialPointsField;

	private JButton addPlayerButton;

	public AddPlayerDialog(MainAppFrame mainFrame) {

		super(mainFrame, "ADD PLAYER");
		this.setModal(true);

		playerIDLabel = new JLabel("Player ID: ");
		playerNameLabel = new JLabel("Player Name: ");
		initialPointsLabel = new JLabel("Initial Points: ");

		// width of text field is 12
		nameTextField = new JTextField(12);
		playerIDField = new JTextField(12);
		initialPointsField = new JTextField(12);

		addPlayerButton = new JButton("ADD");
		// passing this into listener for convenience instead of calling subsequent
		// accessor on frame
		addPlayerButton.addActionListener(new AddPlayerActionListener(mainFrame, this));

		this.setLayout(new GridBagLayout());

		GridBagConstraints gridBagConstraints = new GridBagConstraints();

		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 1;

		// first row
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
		add(playerIDField, gridBagConstraints);

		// second row
		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = GridBagConstraints.LINE_END;
		gridBagConstraints.insets = new Insets(0, 0, 0, 5);
		add(playerNameLabel, gridBagConstraints);

		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = GridBagConstraints.LINE_START;
		gridBagConstraints.insets = new Insets(0, 0, 0, 0);
		add(nameTextField, gridBagConstraints);

		// third row
		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 0;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = GridBagConstraints.LINE_END;
		gridBagConstraints.insets = new Insets(0, 0, 0, 5);
		add(initialPointsLabel, gridBagConstraints);

		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		gridBagConstraints.insets = new Insets(0, 0, 0, 0);
		add(initialPointsField, gridBagConstraints);

		// fourth row
		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 2;
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.insets = new Insets(0, 0, 0, 0);
		gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		add(addPlayerButton, gridBagConstraints);

		this.setBounds(X_COORDINATE_OF_FRAME, Y_COORDINATE_OF_FRAME, FRAME_WIDTH, FRAME_HEIGHT);
		this.setVisible(true);

	}

	public JTextField getNameTextField() {
		return nameTextField;
	}

	public JTextField getPlayerIDField() {
		return playerIDField;
	}

	public JTextField getPlayerInitialPointsField() {
		return initialPointsField;
	}
}

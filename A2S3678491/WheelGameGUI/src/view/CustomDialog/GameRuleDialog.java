package view.CustomDialog;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JTextArea;

import main.MainAppFrame;

/**
 * 
 * A view class invoked when hitting gameRule in Menu
 * 
 * 
 * @author Tuan Vu
 */

@SuppressWarnings("serial")
public class GameRuleDialog extends JDialog {

	private static final int X_COORDINATE_OF_FRAME = 400;
	private static final int Y_COORDINATE_OF_FRAME = 250;
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 250;
	private static final int FONT_SIZE = 12;

	private JTextArea gameRuleText;

	public GameRuleDialog(MainAppFrame frame) {

		super(frame, "ROULETTE GAME RULE");
		this.setModal(true);
		this.setLayout(new BorderLayout());
		gameRuleText = new JTextArea(this.getWidth(), this.getHeight());

		gameRuleText.setFont(new Font("Calibri", Font.BOLD, FONT_SIZE));
		gameRuleText.setEditable(false);
		gameRuleText.setText("\nBEGIN BY SELECTING YOUR BETTYPE AND BET FOR THE FIRST ROUND\n\n"
				+ "THE WHEEL WILL BE AUTOMATICALLY SPINNED ONCE ALL PLAYERS PLACE\nTHEIR BET, THE RESULT IS THE NUMBER AND COLOUR SLOT\n\n"
				+ "AFTER THE FIRST ROUND YOU CAN COMMIT TWO ACTIONS:\n\n"
				+ "1. PLACE YOUR BET WITH YOUR CHOSEN BET TYPE\n"
				+ "2. NOT PARTICIPATE IN THIS ROUND BY NOT PLACING ANY BET\n\n"
				+ "THE HOUSE THEN SPINS THE WHEEL AND WIN/LOSS IS DETERMINED\nBASED ON NUMBER AND COLOUR SLOT");

		this.add(gameRuleText, BorderLayout.CENTER);
		this.setBounds(X_COORDINATE_OF_FRAME, Y_COORDINATE_OF_FRAME, FRAME_WIDTH, FRAME_HEIGHT);
		this.setVisible(true);

	}
}

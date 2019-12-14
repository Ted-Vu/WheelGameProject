package view.WheelFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import main.MainAppFrame;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.winloss.ViewModelWinLoss;

/**
 * A view class which is always visible to show player's information
 * according to the requirement from the specs
 * 
 * 
 * @author Tuan Vu
 */

@SuppressWarnings("serial")
public class SummaryPanel extends JPanel {

	private static final int PANEL_WIDTH = 160;
	private static final int PANEL_HEIGHT = 10;
	private static final int FONT_SIZE = 12;

	private JTextArea summaryArea;
	private StringBuffer summaryResult;

	private GameEngine ge;
	private ViewModelWinLoss viewModelWinLoss;

	private boolean spinWheel;

	public SummaryPanel(MainAppFrame frame) {

		ge = frame.getGameEngineImpl();

		setLayout(new BorderLayout());

		Border innerBorder = BorderFactory.createTitledBorder("SUMMARY PANEL");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

		this.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

		summaryArea = new JTextArea(5, 31);
		Font font = new Font("Calibri", Font.BOLD, FONT_SIZE);
		summaryArea.setFont(font);
		summaryArea.setEditable(false);

		JScrollPane sp = new JScrollPane(summaryArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(sp, BorderLayout.CENTER);
		viewModelWinLoss = new ViewModelWinLoss(ge, this);
		spinWheel = false;

	}

	public void keepRecordBeforeSpin() {
		viewModelWinLoss.setBeforeSpinScore();
	}

	public void keepRecordAfterSpin() {
		viewModelWinLoss.setAfterSpinScore();
	}

	public void setSpinWheel() {
		spinWheel = true;
	}

	public void updateSummaryPanel() {
		summaryResult = new StringBuffer();

		int index = 0;

		if (spinWheel == true) {
			keepRecordAfterSpin();
		}
		if (ge.getAllPlayers().isEmpty() == false) {
			for (Player player : ge.getAllPlayers()) {

				if (spinWheel == false) {
					if (player.getBetType() == null && player.getBet() == 0) {
						summaryResult.append(String.format(
								"PLAYER ID: %s\nPLAYER NAME: %s\nCURRENT BET: %d\nBET TYPE: %s\nPOINTS: %d\nRESULT: %s\n--------------------\n",
								player.getPlayerId(), player.getPlayerName(), 0, "NO", player.getPoints(), "NO"));
					} else {
						summaryResult.append(String.format(
								"PLAYER ID: %s\nPLAYER NAME: %s\nCURRENT BET: %d\nBET TYPE:%s\nPOINTS: %d\nRESULT: %s\n--------------------\n",
								player.getPlayerId(), player.getPlayerName(), player.getBet(), player.getBetType(),
								player.getPoints(), "NO"));
					}
				} else if (spinWheel == true) {
					summaryResult.append(String.format(
							"PLAYER ID: %s\nPLAYER NAME: %s\nCURRENT BET: %d\nBET TYPE: %s\nPOINTS: %d\nRESULT: %s\n--------------------\n",
							player.getPlayerId(), player.getPlayerName(), player.getBet(), player.getBetType(),
							player.getPoints(), viewModelWinLoss.resultAfterSpin(index)));
				}
				++index;
			}
			summaryArea.setText(summaryResult.toString());
		} else {
			summaryArea.setText("");
		}
		if (spinWheel == true) {
			viewModelWinLoss.resetBeforeSpinScore();
			viewModelWinLoss.resetAfterSpinScore();
		}

		// end wheel spinning
		spinWheel = false;
	}

	public boolean getSpinStatus() {
		return spinWheel;
	}

}

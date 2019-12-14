package model.winloss;

import java.util.ArrayList;
import java.util.List;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.WheelFrame.SummaryPanel;

/**
 * 
 * A view-model class to implement the feature stating WIN/LOSS after every
 * spin. This class has two Lists of score and performs calculation to determine
 * WIN/LOSS
 * 
 * @author Tuan Vu
 */

public class ViewModelWinLoss {

	private List<Integer> beforeSpinScore = new ArrayList<>();
	private List<Integer> afterSpinScore = new ArrayList<>();
	private GameEngine gameEngineImpl;
	private boolean displayWinLoss;
	private SummaryPanel summaryPanel;

	public ViewModelWinLoss(GameEngine gameEngineImpl, SummaryPanel summaryPanel) {
		displayWinLoss = false;
		this.summaryPanel = summaryPanel;
		this.gameEngineImpl = gameEngineImpl;
	}

	public void setBeforeSpinScore() {
		for (Player player : gameEngineImpl.getAllPlayers()) {
			beforeSpinScore.add(player.getPoints());
		}
	}

	public void setAfterSpinScore() {

		for (Player player : gameEngineImpl.getAllPlayers()) {
			afterSpinScore.add(player.getPoints());
		}
	}

	public boolean displayWinLoss(int index) {
		if (summaryPanel.getSpinStatus() == true) {
			if (beforeSpinScore.get(index).intValue() == afterSpinScore.get(index).intValue()) {
				displayWinLoss = false;
			} else {
				displayWinLoss = true;
			}
		}
		return displayWinLoss;
	}

	public String resultAfterSpin(int index) {
		String result = "NOT PARTICIPATE";

		if (beforeSpinScore.get(index).intValue() < afterSpinScore.get(index).intValue()) {
			result = "WIN";
		} else if (beforeSpinScore.get(index).intValue() > afterSpinScore.get(index).intValue()) {
			result = "LOSS";
		}
		return result;
	}

	public void resetBeforeSpinScore() {
		beforeSpinScore.clear();
	}

	public void resetAfterSpinScore() {
		afterSpinScore.clear();
	}
}

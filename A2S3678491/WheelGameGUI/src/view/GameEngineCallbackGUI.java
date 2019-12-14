package view;

import javax.swing.SwingUtilities;

import main.MainAppFrame;
import model.interfaces.GameEngine;
import model.interfaces.Slot;
import view.OperationFrame.PlaceBetAndAddPanel;
import view.OperationFrame.RemovePanel;
import view.WheelFrame.SpinToolbar;
import view.WheelFrame.StatusBar;
import view.WheelFrame.SummaryPanel;
import view.WheelFrame.WheelPanel;
import view.interfaces.GameEngineCallback;

/**
 * A view-listener class which is responsible for updating views and model while
 * spinning and showing result by calling methods on views and model
 * appropriately UI update is only done in UI Thread
 * 
 * 
 * @author Tuan Vu
 * 
 */

public class GameEngineCallbackGUI implements GameEngineCallback {

	private PlaceBetAndAddPanel placeBetAndAddPanel;
	private RemovePanel removePanel;
	private SummaryPanel summaryPanel;
	private WheelPanel wheelPanel;
	private SpinToolbar spinToolbar;
	private StatusBar statusBar;

	public GameEngineCallbackGUI(MainAppFrame frame) {

		statusBar = frame.getStatusBar();
		placeBetAndAddPanel = frame.getOperationPanel().getPlaceBetAndAddPanel();
		removePanel = frame.getOperationPanel().getRemovePanel();
		summaryPanel = frame.getSummaryPanel();
		wheelPanel = frame.getWheelPanel();
		spinToolbar = frame.getSpinToolbar();
	}

	@Override
	public void nextSlot(Slot slot, GameEngine engine) {

		// separate UI Thread to update UI
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// update wheel panel during spin
				wheelPanel.updateWheelPanel(slot.getPosition());

			}
		});
	}

	@Override
	public void result(Slot winningSlot, GameEngine engine) {

		// separate UI Thread to update UI when spin finished
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				summaryPanel.updateSummaryPanel();
				spinToolbar.updateSpinMenu();

				// update button in main frame
				placeBetAndAddPanel.updateButtonAfterSpin();
				removePanel.updateRemoveButtonAfterSpin();
				spinToolbar.updateSpinButtonAfterSpin();

				// update status bar
				statusBar.updateStatusBarAfterSpin();

				// update wheelPanel when spin ends
				wheelPanel.updateWheelPanel(winningSlot.getPosition());
			}
		});

	}

}

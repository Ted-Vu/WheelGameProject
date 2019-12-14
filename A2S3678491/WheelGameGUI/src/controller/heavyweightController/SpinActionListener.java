package controller.heavyweightController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainAppFrame;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineCallbackGUI;
import view.GameEngineCallbackImpl;
import view.MessageDialog.NotificationDialogForSpinning;
import view.WheelFrame.SpinToolbar;
import view.WheelFrame.SummaryPanel;
import view.interfaces.GameEngineCallback;

/**
 * 
 * This class is responsible for invoking spin() method in model, since spin()
 * is a long action due to delay, new thread is created to serve as a background
 * thread in order to ensure smooth UI operation.
 * 
 * An assumption is that while spinning all operation buttons are disable (the
 * specs does not mention the effect of multiple spins or adding players while
 * spinning,...). This is also to enforce the game rule: players are only
 * allowed to place bet before spin.
 *
 * @author Tuan Vu
 */

public class SpinActionListener implements ActionListener {

	private static final int INITIAL_DELAY = 1;
	private static final int FINAL_DELAY = 200;
	private static final int DELAY_INCREMENT = 4;

	private GameEngine gameEngineImpl;

	private SummaryPanel summaryPanel;
	private SpinToolbar spinToolbar;
	private MainAppFrame frame;

	private NotificationDialogForSpinning notification;

	public SpinActionListener(MainAppFrame frame) {
		this.frame = frame;

		summaryPanel = frame.getSummaryPanel();
		gameEngineImpl = frame.getGameEngineImpl();
		notification = new NotificationDialogForSpinning(frame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		boolean chooseBetType = true;
		int countPlayerNoBetType = 0;

		for (Player players : gameEngineImpl.getAllPlayers()) {
			if (players.getBetType() == null) {
				chooseBetType = false;
				countPlayerNoBetType++;
			}
		}

		// only allow wheel to spin when all players have chosen their bet type and
		// there exists player
		if (chooseBetType && !(gameEngineImpl.getAllPlayers().isEmpty())) {

			GameEngineCallback GEC = new GameEngineCallbackImpl();
			GameEngineCallback GECGUI = new GameEngineCallbackGUI(frame);

			gameEngineImpl.getWheelSlots();
			gameEngineImpl.addGameEngineCallback(GEC);
			gameEngineImpl.addGameEngineCallback(GECGUI);
			summaryPanel.keepRecordBeforeSpin();
			summaryPanel.setSpinWheel();

			// new thread here to execute long action of spin due to delay
			new Thread() {
				@Override
				public void run() {
					gameEngineImpl.spin(INITIAL_DELAY, FINAL_DELAY, DELAY_INCREMENT);
					for (Player player : gameEngineImpl.getAllPlayers()) {
						player.resetBet();
					}
					gameEngineImpl.removeGameEngineCallback(GEC);
					gameEngineImpl.removeGameEngineCallback(GECGUI);

				}
			}.start();

			// to disable the operation buttons during spin
			// only enable when spin finishes
			spinToolbar = frame.getSpinToolbar();
			frame.getStatusBar().updateStatusBarDuringSpin(spinToolbar.getListOfPlayer().getItemCount());
			frame.getSpinToolbar().updateSpinButtonDuringSpin();
			frame.getOperationPanel().getPlaceBetAndAddPanel().updateButtonDuringspin();
			frame.getOperationPanel().getRemovePanel().updateRemoveButtonDuringSpin();
		} else if (!chooseBetType) {
			notification.showMessageWhenNoBetType(countPlayerNoBetType);
		} else if (gameEngineImpl.getAllPlayers().isEmpty()) {
			notification.showMessageWhenNoPlayerJoining();
		}

	}

}

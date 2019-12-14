package main;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import view.OperationFrame.OperationPanel;
import view.WheelFrame.SpinToolbar;
import view.WheelFrame.StatusBar;
import view.WheelFrame.SummaryPanel;
import view.WheelFrame.WheelPanel;

/**
 * 
 * Main App Frame will keep reference of all the views and model, it also has the 
 * accessors to those views and model in order to pass to listener for updating
 * 
 * 
 * @author Tuan Vu
 * 
 */

@SuppressWarnings("serial")
public class MainAppFrame extends JFrame {

	private static final int X_COORDINATE_OF_FRAME = 200;
	private static final int Y_COORDINATE_OF_FRAME = 60;
	private static final int FRAME_WIDTH = 750;
	private static final int FRAME_HEIGHT = 420;

	private OperationPanel operationPanel;
	private WheelPanel wheelPanel;
	private SummaryPanel summaryPanel;
	private SpinToolbar spinToolbar;
	private StatusBar statusBar;

	private GameEngine gameEngineImpl;

	public MainAppFrame() {
		super("ROULETTE WHEEL GAME");
		setLayout(new BorderLayout());

		gameEngineImpl = new GameEngineImpl();

		summaryPanel = new SummaryPanel(this);

		spinToolbar = new SpinToolbar(this);

		operationPanel = new OperationPanel(this);

		wheelPanel = new WheelPanel(this);

		statusBar = new StatusBar(this);

		this.add(operationPanel, BorderLayout.EAST);
		this.add(wheelPanel, BorderLayout.CENTER);
		this.add(spinToolbar, BorderLayout.NORTH);
		this.add(summaryPanel, BorderLayout.WEST);
		this.add(statusBar, BorderLayout.SOUTH);

		this.setBounds(X_COORDINATE_OF_FRAME, Y_COORDINATE_OF_FRAME, FRAME_WIDTH, FRAME_HEIGHT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	public SummaryPanel getSummaryPanel() {
		return summaryPanel;
	}

	public OperationPanel getOperationPanel() {
		return operationPanel;
	}

	public WheelPanel getWheelPanel() {
		return wheelPanel;
	}

	public SpinToolbar getSpinToolbar() {
		return spinToolbar;
	}

	public StatusBar getStatusBar() {
		return statusBar;
	}

	public GameEngine getGameEngineImpl() {
		return gameEngineImpl;
	}

}

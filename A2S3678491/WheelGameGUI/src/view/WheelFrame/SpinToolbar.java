package view.WheelFrame;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

import controller.heavyweightController.SpinActionListener;
import controller.lightweightController.InitiateExitMenu;
import controller.lightweightController.InitiateGameRuleMenu;
import controller.lightweightController.InitiateOddDialog;
import main.MainAppFrame;
import model.interfaces.GameEngine;
import model.interfaces.Player;

/**
 * A view class which contains three main components spinButton, comboBox and
 * Menu
 * 
 * 
 * @author Tuan Vu
 */

@SuppressWarnings("serial")
public class SpinToolbar extends JToolBar {

	private GameEngine gameEngineImpl;

	private JButton spinButton;
	private JComboBox<String> listOfPlayer;
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem menuItemGameRule;
	private JMenuItem menuItemOdd;
	private JMenuItem menuItemExit;

	public SpinToolbar(MainAppFrame frame) {
		setLayout(new BorderLayout());

		gameEngineImpl = frame.getGameEngineImpl();
		spinButton = new JButton("SPIN");
		spinButton.addActionListener(new SpinActionListener(frame));

		listOfPlayer = new JComboBox<>();

		menuBar = new JMenuBar();
		menu = new JMenu("MENU");
		menu.setMnemonic(KeyEvent.VK_M);

		menuBar.add(menu);

		menuItemGameRule = new JMenuItem("Game Rules");
		menuItemGameRule.setMnemonic(KeyEvent.VK_G);
		menuItemGameRule.addActionListener(new InitiateGameRuleMenu(frame));

		menuItemOdd = new JMenuItem("Odds");
		menuItemOdd.setMnemonic(KeyEvent.VK_O);
		menuItemOdd.addActionListener(new InitiateOddDialog(frame));

		menuItemExit = new JMenuItem("Exit");
		menuItemExit.setMnemonic(KeyEvent.VK_E);
		menuItemExit.addActionListener(new InitiateExitMenu(frame));

		menu.add(menuItemGameRule);
		menu.addSeparator();
		menu.add(menuItemOdd);
		menu.addSeparator();
		menu.add(menuItemExit);

		this.add(spinButton, BorderLayout.WEST);
		this.add(listOfPlayer, BorderLayout.CENTER);
		this.add(menuBar, BorderLayout.EAST);
	}

	public void updateSpinMenu() {
		listOfPlayer.removeAllItems();

		for (Player player : gameEngineImpl.getAllPlayers()) {
			if (player.getBet() != 0) {
				listOfPlayer.addItem(player.getPlayerName());
			}
		}

	}

	public JButton getSpinButton() {
		return spinButton;
	}

	public JComboBox<String> getListOfPlayer() {
		return listOfPlayer;
	}

	public void updateSpinButtonAfterSpin() {
		spinButton.setEnabled(true);
	}

	public void updateSpinButtonDuringSpin() {
		spinButton.setEnabled(false);
	}
}

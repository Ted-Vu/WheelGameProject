package view.OperationFrame;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import main.MainAppFrame;

/**
 * 
 * A view class which serves as a container to contain placeBetAndAddPanel and
 * RemovePanel
 * 
 * 
 * @author Tuan Vu
 */

@SuppressWarnings("serial")
public class OperationPanel extends JPanel {

	private static final int NUMBER_OF_ROW = 2;
	private static final int NUMBER_OF_COLUMN = 1;
	private static final int WIDTH_OF_PANEL = 230;
	private static final int HEIGHT_OF_PANEL = 0;

	private PlaceBetAndAddPanel placeBetAndAddPanel;
	private RemovePanel removePanel;

	public OperationPanel(MainAppFrame frame) {
		placeBetAndAddPanel = new PlaceBetAndAddPanel(frame);
		removePanel = new RemovePanel(frame);

		setLayout(new GridLayout(NUMBER_OF_ROW, NUMBER_OF_COLUMN));

		setBorder(BorderFactory.createEtchedBorder());
		this.setPreferredSize(new Dimension(WIDTH_OF_PANEL, HEIGHT_OF_PANEL));

		this.add(placeBetAndAddPanel);
		this.add(removePanel);
	}

	public RemovePanel getRemovePanel() {
		return removePanel;
	}

	public PlaceBetAndAddPanel getPlaceBetAndAddPanel() {
		return placeBetAndAddPanel;
	}

}

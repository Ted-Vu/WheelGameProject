package view.CustomDialog;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import main.MainAppFrame;

/**
 * 
 * A view class invoked when hitting odds in Menu
 * 
 * 
 * @author Tuan Vu
 */

@SuppressWarnings("serial")
public class OddsTableDialog extends JDialog {

	private static final int X_COORDINATE_OF_FRAME = 150;
	private static final int Y_COORDINATE_OF_FRAME = 250;
	private static final int FRAME_WIDTH = 1000;
	private static final int FRAME_HEIGHT = 250;
	private static final int MAXIMUM_COLUMN = 4;
	private static final int ROW_HEIGHT = 50;
	private static final int WIDTH_OF_FIRST_COLUMN = 5;
	private static final int FONT_SIZE_HEADER = 18;
	private static final int FONT_SIZE_CELL = 12;

	private JTable oddTable;
	private String[] columnName = { "Bet Type", "Odds", "Description", "Example" };

	private Object[][] data = { { "RED", "1 to 1", "Win on red slot/number", "Bet 100 win or lose 100" },
			{ "BLACK", "1 to 1", "Win on black slot/number", "Bet 100 win or lose 100" },
			{ "ZEROS", "WHEEL_SIZE/2 - 1 to 1 for win, 1 to 1 for loss", "Win on green 0 or 00 slots",
					"Bet 100 win 1800 or lose 100" } };

	public OddsTableDialog(MainAppFrame mainFrame) {

		super(mainFrame, "ODD TABLE");
		this.setModal(true);
		this.setLayout(new BorderLayout());

		oddTable = new JTable(data, columnName);

		for (int i = 0; i < MAXIMUM_COLUMN; i++) {
			TableColumn column = oddTable.getColumnModel().getColumn(i);
			if (i == 0) {
				column.setPreferredWidth(WIDTH_OF_FIRST_COLUMN);
				;
			}
		}

		oddTable.getTableHeader().setFont(new Font("Calibri", Font.BOLD, FONT_SIZE_HEADER));
		oddTable.setFont(new Font("Calibri", 18, FONT_SIZE_CELL));

		oddTable.setRowHeight(0, ROW_HEIGHT);
		oddTable.setRowHeight(1, ROW_HEIGHT);
		oddTable.setRowHeight(2, ROW_HEIGHT);

		oddTable.setShowVerticalLines(true);
		oddTable.setShowHorizontalLines(true);

		this.add(new JScrollPane(oddTable), BorderLayout.CENTER);

		this.setBounds(X_COORDINATE_OF_FRAME, Y_COORDINATE_OF_FRAME, FRAME_WIDTH, FRAME_HEIGHT);
		this.setVisible(true);

	}

}

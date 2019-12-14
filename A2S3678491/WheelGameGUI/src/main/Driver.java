package main;

import javax.swing.SwingUtilities;

/**
 * 
 * Application starts running here
 * 
 * 
 * @author Tuan Vu
 */

public class Driver {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new MainAppFrame();
			}

		});

	}
}

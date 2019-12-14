package view.WheelFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import main.MainAppFrame;
import model.interfaces.Slot;

/**
 * A view class which is responsible for redrawing graphics while spinning and
 * showing result.
 * 
 * 1) WheelImage is always drawn square in order to have circular wheel 2)
 * Coordination of WheelImage is determined dynamically based on getWidth() and
 * getHeight() separated into three main cases 3) Coordination of ball is
 * determined dynamically based on getWidth() and getHeight() with meticulous
 * scaling in order to be redrawn correctly
 * 
 * @author Tuan Vu
 */

@SuppressWarnings("serial")
public class WheelPanel extends JPanel {

	private static final int FIRST_SLOT_POSITION = 0;
	private static final double RADIUS_OF_BALL = 5.5;
	private static final double ESTIMATED_RATIO_DIFFERENCE_BETWEEN_RADIUS = 0.08;
	private static final String FILE_NAME = "wheel.png";

	private BufferedImage wheelImage;
	private Image scaledImage;

	private int slotPosition;


	public WheelPanel(MainAppFrame frame) {

		try {
			wheelImage = ImageIO.read(new File("images" + File.separator + FILE_NAME));

		} catch (IOException e) {
			e.printStackTrace();
		}

		this.setLayout(new BorderLayout());
		slotPosition = FIRST_SLOT_POSITION;
	}

	@Override
	protected void paintComponent(Graphics g) {

		Graphics2D g2D = (Graphics2D) g;

		// set these params to achieve high quality graphics when drawing image
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

		super.paintComponent(g2D);

		// compute all the params before drawing
		double radiusOfWheel = (getWidth() > getHeight()) ? getHeight() / 2.0
				: (getWidth() < getHeight()) ? getWidth() / 2.0 : (getWidth() + getHeight()) / 2.0;
		double radiusOfCircleCreatedWhenBallRolling = radiusOfWheel - radiusOfWheel * ESTIMATED_RATIO_DIFFERENCE_BETWEEN_RADIUS;

		int xCoordinateOfImage = (getWidth() > getHeight()) ? (getWidth() / 2 - (int) (radiusOfWheel)) : 0;
		int yCoordinateOfImage = (getWidth() < getHeight()) ? (getHeight() / 2 - (int) (radiusOfWheel)) : 0;

		int xCoordinateOfBall = (int) Math.round((radiusOfCircleCreatedWhenBallRolling
				* Math.cos(Math.toRadians(calculateAngle(slotPosition).doubleValue())) + getWidth() / 2.0
				- RADIUS_OF_BALL));
		int yCoordinateOfBall = (int) Math
				.round((getHeight()
						- (getHeight() / 2.0 + radiusOfCircleCreatedWhenBallRolling
								* Math.sin(Math.toRadians(calculateAngle(slotPosition).doubleValue())))
						- RADIUS_OF_BALL));

		// draw the wheel here
		scaledImage = wheelImage.getScaledInstance((int) (radiusOfWheel * 2), (int) (radiusOfWheel * 2),
				Image.SCALE_SMOOTH);
		g2D.drawImage(scaledImage, xCoordinateOfImage, yCoordinateOfImage, this);

		// draw the ball here
		g2D.setColor(Color.YELLOW);
		g2D.fillOval(xCoordinateOfBall, yCoordinateOfBall, (int) (RADIUS_OF_BALL * 2), (int) (RADIUS_OF_BALL * 2));

	}

	// to increase precision using BigDecimal instead of double
	private BigDecimal calculateAngle(int slotPosition) {
		BigDecimal angle = new BigDecimal(90.0 - (360.0 / Slot.WHEEL_SIZE) * slotPosition);

		return angle;
	}

	public void setSlotPosition(int slotPosition) {
		this.slotPosition = slotPosition;
	}

	public void updateWheelPanel(int slotPosition) {
		this.setSlotPosition(slotPosition);
		this.repaint();
	}

}

package window.listeners;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import window.WindowManager;
import window.render3d.Render3D;

public class WindowMouseMotionListener implements MouseMotionListener {
	
	private double sensitivity = .1;
	
	@Override
	public void mouseDragged(MouseEvent mouseEvent) {
		
	}

	@Override
	public void mouseMoved(MouseEvent mouseEvent) {
		int mouseX = mouseEvent.getX();
		int mouseY = mouseEvent.getY();
		
		int deltaX = mouseX - WindowManager.WINDOW_WIDTH / 2;
		int deltaY = mouseY - WindowManager.WINDOW_HEIGHT / 2;
		
		Render3D.translateYaw(-1 * deltaX * sensitivity);
		Render3D.translatePitch(deltaY * sensitivity);

		try {
			Robot robot = new Robot();
			int xcoord = (int) WindowManager.getJFrameInstance().getLocation().getX();
			int ycoord = (int) WindowManager.getJFrameInstance().getLocation().getY();
			robot.mouseMove(xcoord + WindowManager.WINDOW_WIDTH / 2, ycoord +  WindowManager.WINDOW_HEIGHT / 2);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * <strong>This is not recommended to be run in itself, please run WindowManager.setSensitivity(int sensitivity).</strong>
	 * <br></br>
	 * Sets the speed at which the pitch and yaw will change at when the mouse is moved.
	 * @param mouseSens desired sensitivity
	 */
	public synchronized void setSensitivity(double mouseSens) {
		this.sensitivity = mouseSens;
	}

	/**
	 * <strong>This is not recommended to be run in itself, please run WindowManager.getSensitivity().</strong>
	 * <br></br>
	 * Gets the speed at which the pitch and yaw will change at when the mouse is moved.
	 */
	public synchronized double getSensitivity() {
		return this.sensitivity;
	}
}

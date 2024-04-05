package window.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import window.render3d.Point3D;
import window.render3d.Render3D;

public class WindowKeyListener implements KeyListener {

	private final Set<Integer> pressedKeys = new HashSet<>();
	private int speed = 15;
	
	
	@Override
	public void keyTyped(KeyEvent keyEvent) {

	}

	@Override
	public synchronized void keyPressed(KeyEvent keyEvent) {
		
		pressedKeys.add(keyEvent.getKeyCode());
        Point3D offset = new Point3D();
        if (!pressedKeys.isEmpty()) {
            for (Iterator<Integer> it = pressedKeys.iterator(); it.hasNext();) {
                switch (it.next()) {
                    case KeyEvent.VK_W:
                    case KeyEvent.VK_UP:
                        offset.z += speed*Math.cos(Math.toRadians(Render3D.getCameraYaw()));
                        offset.x += -speed*Math.sin(Math.toRadians(Render3D.getCameraYaw()));
                        break;
                    case KeyEvent.VK_A:
                    case KeyEvent.VK_LEFT:
                        offset.z += -speed*Math.sin(Math.toRadians(Render3D.getCameraYaw()));
                        offset.x += -speed*Math.cos(Math.toRadians(Render3D.getCameraYaw()));
                        break;
                    case KeyEvent.VK_S:
                    case KeyEvent.VK_DOWN:
                        offset.z += -speed*Math.cos(Math.toRadians(Render3D.getCameraYaw()));
                        offset.x += speed*Math.sin(Math.toRadians(Render3D.getCameraYaw()));
                        break;
                    case KeyEvent.VK_D:
                    case KeyEvent.VK_RIGHT:
                        offset.z += speed*Math.sin(Math.toRadians(Render3D.getCameraYaw()));
                        offset.x += speed*Math.cos(Math.toRadians(Render3D.getCameraYaw()));
                        break;
                    case KeyEvent.VK_SPACE:
                    	offset.y += -speed;
                    	break;
                    case KeyEvent.VK_SHIFT:
                    	offset.y += speed;
                    	break;
                }
            }
        }
        
        Render3D.translateCamera(offset);
	}

	@Override
	public synchronized void keyReleased(KeyEvent keyEvent) {
		pressedKeys.remove(keyEvent.getKeyCode());
	}
	
	/**
	 * <strong>This is not recommended to be run in itself, please run WindowManager.setSpeed(int speed).</strong>
	 * <br></br>
	 * Sets the speed at which the camera will move when the proper movement key(s) are pressed.
	 * @param speed desired speed
	 */
	public synchronized void setCameraSpeed(int speed) {
		this.speed = speed;
	}
	
	/**
	 * <strong>This is not recommended to be run in itself, please run WindowManager.getSpeed().</strong>
	 * <br></br>
	 * Gets the speed at which the camera will move when the proper movement key(s) are pressed.
	 */
	public synchronized int getCameraSpeed() {
		return this.speed;
	}

}

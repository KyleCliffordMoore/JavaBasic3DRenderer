package window;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import window.listeners.WindowKeyListener;
import window.listeners.WindowMouseListener;
import window.listeners.WindowMouseMotionListener;

public class WindowManager {

	public static final String WINDOW_TITLE  = "This is a title";
	public static final int    WINDOW_WIDTH  = 800;
	public static final int    WINDOW_HEIGHT = 600;
	
	private static JFrame window;
	private static JPanel jPanel;
	private static WindowKeyListener windowKeyListener;
	private static WindowMouseListener windowMouseListener;
	private static WindowMouseMotionListener windowMouseMotionListener;
	
	public static void setUp() {
		window = new JFrame(WINDOW_TITLE);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
		window.setBounds(
				(int) (screenDimensions.width - WINDOW_WIDTH) >> 1,
				(int) (screenDimensions.height - WINDOW_HEIGHT) >> 1,
				WINDOW_WIDTH,
				WINDOW_HEIGHT
			);
		
		window.setVisible(true);
		
		jPanel = new WindowCanvas();
		jPanel.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		
		window.add(jPanel);
		window.pack();
	}
	
	public static void step() {
		window.validate();
		window.repaint();
	}
	
	public static void initWindowKeyListener() {
		windowKeyListener = new WindowKeyListener();
		window.addKeyListener(windowKeyListener);
	}
	
	public static void initWindowMouseListener() {
		windowMouseListener = new WindowMouseListener();
		window.addMouseListener(windowMouseListener);
	}
	
	public static void initWindowMouseMotionListener() {
		windowMouseMotionListener = new WindowMouseMotionListener();
		window.addMouseMotionListener(windowMouseMotionListener);
	}
	
	public static JFrame getJFrameInstance() {
		return window;
	}
	
	public static JPanel getJPanelInstance() {
		return jPanel;
	}
	
	public static WindowKeyListener getWindowKeyListenerInstance() {
		return windowKeyListener;
	}
	
	public static WindowMouseListener getWindowMouseListenerInstance() {
		return windowMouseListener;
	}
	
	public static WindowMouseMotionListener getWindowMouseMotionListenerInstance() {
		return windowMouseMotionListener;
	}
	
	public static void setCameraSpeed(int speed) {
		windowKeyListener.setCameraSpeed(speed);
	}
	
	public static int getCameraSpeed() {
		return windowKeyListener.getCameraSpeed();
	}
	
	public static void setMouseSensitivity(double mouseSens) {
		windowMouseMotionListener.setSensitivity(mouseSens);
	}
	
	public static double getMouseSensitivity() {
		return windowMouseMotionListener.getSensitivity();
	}
}

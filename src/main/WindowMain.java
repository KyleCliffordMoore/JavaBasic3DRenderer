package main;

import window.WindowManager;
import window.render3d.Render3D;

public class WindowMain {

	public static void main(String[] args) {
		WindowManager.setUp();
		WindowManager.initWindowMouseMotionListener();
		WindowManager.initWindowKeyListener();
		
		Render3D.setCameraPosition(WindowManager.WINDOW_WIDTH / 2 , WindowManager.WINDOW_HEIGHT / 2, 0);
		
		
		while(true) {
			
			WindowManager.step();
			
			try {
				Thread.sleep(10);
			} catch (Exception e) {/* Ignore this */}
		}
		
	}

}

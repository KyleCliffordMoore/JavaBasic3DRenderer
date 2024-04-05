package window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import window.render3d.shapes.Cube;


public class WindowCanvas extends JPanel {

	private static final long serialVersionUID = -2436338355416987232L;

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		
		Graphics2D graphics2D = (Graphics2D) graphics;
		
		int size = 5;
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				Cube cube = new Cube(100*i, 100*j, 100, 100);
				graphics2D.setColor(new Color(0, 125, 125));
				cube.render(graphics2D);
			}
		}
		
	}
	
}

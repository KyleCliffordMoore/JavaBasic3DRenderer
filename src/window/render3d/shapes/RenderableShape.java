package window.render3d.shapes;

import java.awt.Graphics2D;

public interface RenderableShape {

	public void render(Graphics2D graphics2D);
	
	public void renderFilled(Graphics2D graphics2D);
}

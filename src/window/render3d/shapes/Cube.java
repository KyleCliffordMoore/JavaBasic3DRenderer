package window.render3d.shapes;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;

import window.render3d.Point3D;
import window.render3d.Render3D;

public class Cube implements RenderableShape {

	double x, y, z, size;
	
	public Cube(Point3D startPoint, double size) {
		this(startPoint.getX(), startPoint.getY(), startPoint.getZ(), size);
	}
	public Cube(int x, int y, int z, double size) {
		this((double) x, (double) y, (double) z, size);
	}
	public Cube(float x, float y, float z, double size) {
		this((double) x, (double) y, (double) z, size);
	}
	
	public Cube(double x, double y, double z, double size) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.size = Math.abs(size);
	}
	
	private Face[] create6Faces() {
		
		Face[] faces6 = new Face[6];
		
		//Face 1 - Top
		faces6[0] = new Face(new Point3D[] {
				new Point3D((int)       x, (int) y, (int)        z),
				new Point3D((int)(x+size), (int) y, (int)        z),
				new Point3D((int)(x+size), (int) y, (int) (z+size)),
				new Point3D((int)       x, (int) y, (int) (z+size))
		});
		
		//Face 2 - Bottom
		faces6[1] = new Face(new Point3D[] {
				new Point3D((int)       x, (int) (y+size), (int)        z),
				new Point3D((int)(x+size), (int) (y+size), (int)        z),
				new Point3D((int)(x+size), (int) (y+size), (int) (z+size)),
				new Point3D((int)       x, (int) (y+size), (int) (z+size))
		});
		
		//Face 3 - Front
		faces6[2] = new Face(new Point3D[] {
				new Point3D((int)       x, (int)        y, (int) z),
				new Point3D((int)(x+size), (int)        y, (int) z),
				new Point3D((int)(x+size), (int) (y+size), (int) z),
				new Point3D((int)       x, (int) (y+size), (int) z)
		});
		
		//Face 4 - Back
		faces6[3] = new Face(new Point3D[] {
				new Point3D((int)       x, (int)        y, (int) (z+size)),
				new Point3D((int)(x+size), (int)        y, (int) (z+size)),
				new Point3D((int)(x+size), (int) (y+size), (int) (z+size)),
				new Point3D((int)       x, (int) (y+size), (int) (z+size))
		});
		
		//Face 5 - Left Side
		faces6[4] = new Face(new Point3D[] {
				new Point3D((int) x, (int)        y, (int)        z),
				new Point3D((int) x, (int)        y, (int) (z+size)),
				new Point3D((int) x, (int) (y+size), (int) (z+size)),
				new Point3D((int) x, (int) (y+size), (int)        z)
		});
		
		//Face 6 - Right Side
		faces6[4] = new Face(new Point3D[] {
				new Point3D((int) (x+size), (int)        y, (int)        z),
				new Point3D((int) (x+size), (int)        y, (int) (z+size)),
				new Point3D((int) (x+size), (int) (y+size), (int) (z+size)),
				new Point3D((int) (x+size), (int) (y+size), (int)        z)
		});
		
		return faces6;
	}
	
	@Override
	public void render(Graphics2D graphics2D) {
		
		
		Point3D pt3d1, pt3d2, pt3d3, pt3d4;
		Point pt1, pt2, pt3, pt4;
		
		//Face 1 - Top
		
		pt3d1 = Render3D.applyCameraViewRotations((int)       x, (int) y, (int)        z);
		pt3d2 = Render3D.applyCameraViewRotations((int)(x+size), (int) y, (int)        z);
		pt3d3 = Render3D.applyCameraViewRotations((int)(x+size), (int) y, (int) (z+size));
		pt3d4 = Render3D.applyCameraViewRotations((int)       x, (int) y, (int) (z+size));
		
		if (!Render3D.points3DBehindCamera(pt3d1, pt3d2, pt3d3, pt3d4)) {
			pt1 = Render3D.toPoint2D(pt3d1);
			pt2 = Render3D.toPoint2D(pt3d2);
			pt3 = Render3D.toPoint2D(pt3d3);
			pt4 = Render3D.toPoint2D(pt3d4);
			
			graphics2D.drawPolygon(
					new int[] {pt1.x, pt2.x, pt3.x, pt4.x},
					new int[] {pt1.y, pt2.y, pt3.y, pt4.y},
					4);
		}
		
		//Face 2 - Bottom
		
		pt3d1 = Render3D.applyCameraViewRotations((int)       x, (int) (y+size), (int)        z);
		pt3d2 = Render3D.applyCameraViewRotations((int)(x+size), (int) (y+size), (int)        z);
		pt3d3 = Render3D.applyCameraViewRotations((int)(x+size), (int) (y+size), (int) (z+size));
		pt3d4 = Render3D.applyCameraViewRotations((int)       x, (int) (y+size), (int) (z+size));
		
		if (!Render3D.points3DBehindCamera(pt3d1, pt3d2, pt3d3, pt3d4)) {
			pt1 = Render3D.toPoint2D(pt3d1);
			pt2 = Render3D.toPoint2D(pt3d2);
			pt3 = Render3D.toPoint2D(pt3d3);
			pt4 = Render3D.toPoint2D(pt3d4);
			
			graphics2D.drawPolygon(
					new int[] {pt1.x, pt2.x, pt3.x, pt4.x},
					new int[] {pt1.y, pt2.y, pt3.y, pt4.y},
					4);
		}
		
		//Face 3 - Front
		
		pt3d1 = Render3D.applyCameraViewRotations((int)       x, (int)        y, (int) z);
		pt3d2 = Render3D.applyCameraViewRotations((int)(x+size), (int)        y, (int) z);
		pt3d3 = Render3D.applyCameraViewRotations((int)(x+size), (int) (y+size), (int) z);
		pt3d4 = Render3D.applyCameraViewRotations((int)       x, (int) (y+size), (int) z);
		
		if (!Render3D.points3DBehindCamera(pt3d1, pt3d2, pt3d3, pt3d4)) {
			pt1 = Render3D.toPoint2D(pt3d1);
			pt2 = Render3D.toPoint2D(pt3d2);
			pt3 = Render3D.toPoint2D(pt3d3);
			pt4 = Render3D.toPoint2D(pt3d4);
			
			graphics2D.drawPolygon(
					new int[] {pt1.x, pt2.x, pt3.x, pt4.x},
					new int[] {pt1.y, pt2.y, pt3.y, pt4.y},
					4);
		}
		
		//Face 4 - Back
		
		pt3d1 = Render3D.applyCameraViewRotations((int)       x, (int)        y, (int) (z+size));
		pt3d2 = Render3D.applyCameraViewRotations((int)(x+size), (int)        y, (int) (z+size));
		pt3d3 = Render3D.applyCameraViewRotations((int)(x+size), (int) (y+size), (int) (z+size));
		pt3d4 = Render3D.applyCameraViewRotations((int)       x, (int) (y+size), (int) (z+size));
		
		if (!Render3D.points3DBehindCamera(pt3d1, pt3d2, pt3d3, pt3d4)) {
			pt1 = Render3D.toPoint2D(pt3d1);
			pt2 = Render3D.toPoint2D(pt3d2);
			pt3 = Render3D.toPoint2D(pt3d3);
			pt4 = Render3D.toPoint2D(pt3d4);
			
			graphics2D.drawPolygon(
					new int[] {pt1.x, pt2.x, pt3.x, pt4.x},
					new int[] {pt1.y, pt2.y, pt3.y, pt4.y},
					4);
		}
		
		//Left and Right do not need to be shown!
		
		//Face 5 - Left Side
		
		pt3d1 = Render3D.applyCameraViewRotations((int) x, (int)        y, (int)        z);
		pt3d2 = Render3D.applyCameraViewRotations((int) x, (int)        y, (int) (z+size));
		pt3d3 = Render3D.applyCameraViewRotations((int) x, (int) (y+size), (int) (z+size));
		pt3d4 = Render3D.applyCameraViewRotations((int) x, (int) (y+size), (int)        z);

		if (!Render3D.points3DBehindCamera(pt3d1, pt3d2, pt3d3, pt3d4)) {
			pt1 = Render3D.toPoint2D(pt3d1);
			pt2 = Render3D.toPoint2D(pt3d2);
			pt3 = Render3D.toPoint2D(pt3d3);
			pt4 = Render3D.toPoint2D(pt3d4);
			
			graphics2D.drawPolygon(
					new int[] {pt1.x, pt2.x, pt3.x, pt4.x},
					new int[] {pt1.y, pt2.y, pt3.y, pt4.y},
					4);
		}
		
		//Face 6 - Right Side
		
		pt3d1 = Render3D.applyCameraViewRotations((int) (x+size), (int)        y, (int)        z);
		pt3d2 = Render3D.applyCameraViewRotations((int) (x+size), (int)        y, (int) (z+size));
		pt3d3 = Render3D.applyCameraViewRotations((int) (x+size), (int) (y+size), (int) (z+size));
		pt3d4 = Render3D.applyCameraViewRotations((int) (x+size), (int) (y+size), (int)        z);
		
		if (!Render3D.points3DBehindCamera(pt3d1, pt3d2, pt3d3, pt3d4)) {
			pt1 = Render3D.toPoint2D(pt3d1);
			pt2 = Render3D.toPoint2D(pt3d2);
			pt3 = Render3D.toPoint2D(pt3d3);
			pt4 = Render3D.toPoint2D(pt3d4);
			
			graphics2D.drawPolygon(
					new int[] {pt1.x, pt2.x, pt3.x, pt4.x},
					new int[] {pt1.y, pt2.y, pt3.y, pt4.y},
					4);
		}
	}
	
	@Override
	public void renderFilled(Graphics2D graphics2D) {
		Point3D pt3d1, pt3d2, pt3d3, pt3d4;
		Point pt1, pt2, pt3, pt4;
		
		//Face 1 - Top
		
		pt3d1 = Render3D.applyCameraViewRotations((int)       x, (int) y, (int)        z);
		pt3d2 = Render3D.applyCameraViewRotations((int)(x+size), (int) y, (int)        z);
		pt3d3 = Render3D.applyCameraViewRotations((int)(x+size), (int) y, (int) (z+size));
		pt3d4 = Render3D.applyCameraViewRotations((int)       x, (int) y, (int) (z+size));
		
		if (!Render3D.points3DBehindCamera(pt3d1, pt3d2, pt3d3, pt3d4)) {
			pt1 = Render3D.toPoint2D(pt3d1);
			pt2 = Render3D.toPoint2D(pt3d2);
			pt3 = Render3D.toPoint2D(pt3d3);
			pt4 = Render3D.toPoint2D(pt3d4);
			
			graphics2D.fillPolygon(
					new int[] {pt1.x, pt2.x, pt3.x, pt4.x},
					new int[] {pt1.y, pt2.y, pt3.y, pt4.y},
					4);
		}
		
		//Face 2 - Bottom
		
		pt3d1 = Render3D.applyCameraViewRotations((int)       x, (int) (y+size), (int)        z);
		pt3d2 = Render3D.applyCameraViewRotations((int)(x+size), (int) (y+size), (int)        z);
		pt3d3 = Render3D.applyCameraViewRotations((int)(x+size), (int) (y+size), (int) (z+size));
		pt3d4 = Render3D.applyCameraViewRotations((int)       x, (int) (y+size), (int) (z+size));
		
		if (!Render3D.points3DBehindCamera(pt3d1, pt3d2, pt3d3, pt3d4)) {
			pt1 = Render3D.toPoint2D(pt3d1);
			pt2 = Render3D.toPoint2D(pt3d2);
			pt3 = Render3D.toPoint2D(pt3d3);
			pt4 = Render3D.toPoint2D(pt3d4);
			
			graphics2D.fillPolygon(
					new int[] {pt1.x, pt2.x, pt3.x, pt4.x},
					new int[] {pt1.y, pt2.y, pt3.y, pt4.y},
					4);
		}
		
		//Face 3 - Front
		
		pt3d1 = Render3D.applyCameraViewRotations((int)       x, (int)        y, (int) z);
		pt3d2 = Render3D.applyCameraViewRotations((int)(x+size), (int)        y, (int) z);
		pt3d3 = Render3D.applyCameraViewRotations((int)(x+size), (int) (y+size), (int) z);
		pt3d4 = Render3D.applyCameraViewRotations((int)       x, (int) (y+size), (int) z);
		
		if (!Render3D.points3DBehindCamera(pt3d1, pt3d2, pt3d3, pt3d4)) {
			pt1 = Render3D.toPoint2D(pt3d1);
			pt2 = Render3D.toPoint2D(pt3d2);
			pt3 = Render3D.toPoint2D(pt3d3);
			pt4 = Render3D.toPoint2D(pt3d4);
			
			graphics2D.fillPolygon(
					new int[] {pt1.x, pt2.x, pt3.x, pt4.x},
					new int[] {pt1.y, pt2.y, pt3.y, pt4.y},
					4);
		}
		
		//Face 4 - Back
		
		pt3d1 = Render3D.applyCameraViewRotations((int)       x, (int)        y, (int) (z+size));
		pt3d2 = Render3D.applyCameraViewRotations((int)(x+size), (int)        y, (int) (z+size));
		pt3d3 = Render3D.applyCameraViewRotations((int)(x+size), (int) (y+size), (int) (z+size));
		pt3d4 = Render3D.applyCameraViewRotations((int)       x, (int) (y+size), (int) (z+size));
		
		if (!Render3D.points3DBehindCamera(pt3d1, pt3d2, pt3d3, pt3d4)) {
			pt1 = Render3D.toPoint2D(pt3d1);
			pt2 = Render3D.toPoint2D(pt3d2);
			pt3 = Render3D.toPoint2D(pt3d3);
			pt4 = Render3D.toPoint2D(pt3d4);
			
			graphics2D.fillPolygon(
					new int[] {pt1.x, pt2.x, pt3.x, pt4.x},
					new int[] {pt1.y, pt2.y, pt3.y, pt4.y},
					4);
		}
		
		//Face 5 - Left Side
		
		pt3d1 = Render3D.applyCameraViewRotations((int) x, (int)        y, (int)        z);
		pt3d2 = Render3D.applyCameraViewRotations((int) x, (int)        y, (int) (z+size));
		pt3d3 = Render3D.applyCameraViewRotations((int) x, (int) (y+size), (int) (z+size));
		pt3d4 = Render3D.applyCameraViewRotations((int) x, (int) (y+size), (int)        z);

		if (!Render3D.points3DBehindCamera(pt3d1, pt3d2, pt3d3, pt3d4)) {
			pt1 = Render3D.toPoint2D(pt3d1);
			pt2 = Render3D.toPoint2D(pt3d2);
			pt3 = Render3D.toPoint2D(pt3d3);
			pt4 = Render3D.toPoint2D(pt3d4);
			
			graphics2D.fillPolygon(
					new int[] {pt1.x, pt2.x, pt3.x, pt4.x},
					new int[] {pt1.y, pt2.y, pt3.y, pt4.y},
					4);
		}
		
		//Face 6 - Right Side
		
		pt3d1 = Render3D.applyCameraViewRotations((int) (x+size), (int)        y, (int)        z);
		pt3d2 = Render3D.applyCameraViewRotations((int) (x+size), (int)        y, (int) (z+size));
		pt3d3 = Render3D.applyCameraViewRotations((int) (x+size), (int) (y+size), (int) (z+size));
		pt3d4 = Render3D.applyCameraViewRotations((int) (x+size), (int) (y+size), (int)        z);
		
		if (!Render3D.points3DBehindCamera(pt3d1, pt3d2, pt3d3, pt3d4)) {
			pt1 = Render3D.toPoint2D(pt3d1);
			pt2 = Render3D.toPoint2D(pt3d2);
			pt3 = Render3D.toPoint2D(pt3d3);
			pt4 = Render3D.toPoint2D(pt3d4);
			
			graphics2D.fillPolygon(
					new int[] {pt1.x, pt2.x, pt3.x, pt4.x},
					new int[] {pt1.y, pt2.y, pt3.y, pt4.y},
					4);
		}
	}
	
	public Face[] getFaces() {
		return create6Faces();
	}
	
	public List<Face> getFacesAsList() {
		return Arrays.asList(create6Faces());
	}
	
	public Point3D getPosition() {
		return new Point3D((int)x, (int)y, (int)z);
	}
	
	double getX() {
		return x;
	}
	
	double getY() {
		return y;
	}
	
	double getZ() {
		return z;
	}
}

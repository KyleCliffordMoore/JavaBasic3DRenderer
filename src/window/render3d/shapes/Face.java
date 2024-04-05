package window.render3d.shapes;

import java.util.Arrays;
import java.util.List;

import window.render3d.Point3D;

public class Face {

	List<Point3D> pts;
	
	public Face(Point3D... point3ds) {
		pts = Arrays.asList(point3ds);
	}
	
	public Face(List<Point3D> point3ds) {
		pts = point3ds;
	}
	
	public List<Point3D> getPointsAsList() {
		return pts;
	}
	
	public Point3D[] getPoints() {
		return (Point3D[]) pts.toArray();
	}
	
	public int getNumberOfPoints() {
		return pts.size();
	}
}

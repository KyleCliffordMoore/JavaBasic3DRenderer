package window.render3d;

import java.awt.Point;
import java.awt.Polygon;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import window.WindowManager;

public class Render3D {
	
	private static int cameraX =   0,
					   cameraY =   0,
					   cameraZ =   0,
					   fov     = 110;
	
	private static double pitch   =   0,
					      roll    =   0,
					      yaw     =   0;
	
	public static void setCameraPosition(Point3D pt3d) {
		setCameraPosition(pt3d.x, pt3d.y, pt3d.z);
	}
	
	public static void setCameraPosition(int x, int y, int z) {
		cameraX = x;
		cameraY = y;
		cameraZ = z;
	}
	
	public static void setYaw(double _yaw) {
		yaw = _yaw;
	}
	
	public static void translateYaw(double _dyaw) {
		yaw += _dyaw;
	}
	
	public static void setPitch(double _pitch) {
		pitch = _pitch;
	}

	public static void translatePitch(double _dpitch) {
		pitch += _dpitch;
	}
	
	public static void setRoll(double _roll) {
		roll = _roll;
	}

	public static void translateRoll(double _droll) {
		roll += _droll;
	}
	
	public static void translateCamera(Point3D pt3d) {
		translateCamera(pt3d.x, pt3d.y, pt3d.z);
	}
	
	public static void translateCamera(int dx, int dy, int dz) {
		cameraX += dx;
		cameraY += dy;
		cameraZ += dz;
	}
	
	public static Point3D getCameraPosition() {
		return new Point3D(cameraX, cameraY, cameraZ);
	}
	
	public static double getCameraYaw() {
		return yaw;
	}
	
	public static double getCameraPitch() {
		return pitch;
	}
	
	public static double getCameraRoll() {
		return roll;
	}
	
	public static Point3D applyCameraViewRotations(Point3D pt3D) {
		return applyCameraViewRotations(pt3D.x, pt3D.y, pt3D.z);
	}
	public static Point3D applyCameraViewRotations(int x, int y, int z) {
		return applyCameraViewRotations((double)x, (double)y, (double)z);
	}
	public static Point3D applyCameraViewRotations(float x, float y, float z) {
		return applyCameraViewRotations((double)x, (double)y, (double)z);
	}
	public static Point3D applyCameraViewRotations(double x, double y, double z) {
		
        // Translate the point and camera
        double translatedX = x - cameraX;
        double translatedY = y - cameraY;
        double translatedZ = z - cameraZ;

        // Perform rotation around the Y-axis (yaw)
        double yawAngle = Math.toRadians(yaw); // Yaw angle in radians
        double cosYaw = Math.cos(yawAngle);
        double sinYaw = Math.sin(yawAngle);

        double yawRotatedX = translatedX * cosYaw + translatedZ * sinYaw;
        double yawRotatedY = translatedY;
        double yawRotatedZ = -translatedX * sinYaw + translatedZ * cosYaw;

        // Perform rotation around the X-axis (pitch)
        double pitchAngle = Math.toRadians(pitch); // Pitch angle in radians
        double cosPitch = Math.cos(pitchAngle);
        double sinPitch = Math.sin(pitchAngle);

        double rotatedX = yawRotatedX;
        double rotatedY = yawRotatedY * cosPitch - yawRotatedZ * sinPitch;
        double rotatedZ = yawRotatedY * sinPitch + yawRotatedZ * cosPitch;


        // Translate the point back
        x = rotatedX + cameraX;
        y = rotatedY + cameraY;
        z = rotatedZ + cameraZ;
		
		return new Point3D((int)x, (int)y, (int)z);
	}
	
	public static Point toPoint2D(Point3D pt3d) { return toPoint2D(pt3d.getX(), pt3d.getY(), pt3d.getZ()); }
	public static Point toPoint2D(int x, int y, int z) { return toPoint2D((double)x, (double)y, (double)z); }
	public static Point toPoint2D(float x, float y, float z) { return toPoint2D((double)x, (double)y, (double)z); }
	public static Point toPoint2D(double x, double y, double z) {
        
	    double F = z - cameraZ;
	    
	    // Calculate the screen distance based on the field of view and camera position
	    double halfFovRad = Math.toRadians(fov / 2);
	    double screenDist = (WindowManager.WINDOW_WIDTH / 2) / Math.tan(halfFovRad);

	    // Perform perspective projection
	    int x2d = (int) (((x - cameraX) * screenDist / F) + (WindowManager.WINDOW_WIDTH / 2));
	    int y2d = (int) (((y - cameraY) * screenDist / F) + (WindowManager.WINDOW_HEIGHT / 2));

        return new Point(x2d, y2d);
	}
	
	public static boolean points3DBehindCamera(Point3D... pt3ds) {
		for (Point3D pt3d : pt3ds)
			if (behindCamera(pt3d.getZ()))
				return true;
		return false;
	}
	public static boolean behindCamera(Point3D pt3d) {return behindCamera(pt3d.getZ());}
	public static boolean behindCamera(int z) {return behindCamera((double)z);}
	public static boolean behindCamera(float z) {return behindCamera((double)z);}
	public static boolean behindCamera(double z) {
		return z - cameraZ < 0;
//		return false;
	}
	
	public static void orderPolygons(List<Polygon> polygons) {
		
        Collections.sort(polygons, new Comparator<Polygon>() {
            @Override
            public int compare(Polygon p1, Polygon p2) {
                //double distance1 = p1.
                //double distance2 = p2.
                //return Double.compare(distance2, distance1); // Sort in descending order
            	return 0;
            }
        });
        
	}
	
}

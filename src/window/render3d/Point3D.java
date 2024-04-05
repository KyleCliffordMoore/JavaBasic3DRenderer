package window.render3d;

public class Point3D extends Point3DAbstract {

    public int x;
    public int y;
    public int z;

    public Point3D() {
        this(0, 0, 0);
    }

    public Point3D(Point3D p) {
        this(p.x, p.y, p.z);
    }

    public Point3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public double getZ() {
        return z;
    }


    public Point3D getLocation() {
        return new Point3D(x, y, z);
    }

    public void setLocation(Point3D p) {
        setLocation(p.x, p.y, p.z);
    }


    public void setLocation(int x, int y, int z) {
        move(x, y, z);
    }

    public void setLocation(double x, double y, double z) {
        this.x = (int) Math.floor(x+0.5);
        this.y = (int) Math.floor(y+0.5);
        this.z = (int) Math.floor(z+0.5);
    }

    public void move(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void translate(int dx, int dy, int dz) {
        this.x += dx;
        this.y += dy;
        this.z += dz;
    }


    public boolean equals(Object obj) {
        if (obj instanceof Point3D) {
            Point3D pt = (Point3D)obj;
            return (x == pt.x) && (y == pt.y) && (z == pt.z);
        }
        return super.equals(obj);
    }

    public String toString() {
        return getClass().getName() + "[x=" + x + ",y=" + y + "," + "z=" + z + "]";
    }
}

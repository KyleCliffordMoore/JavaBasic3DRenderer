package window.render3d;

public abstract class Point3DAbstract implements Cloneable {

    public static class Float extends Point3DAbstract {

		public float x;
        public float y;
        public float z;
        
        public Float() {
        }

        public Float(float x, float y, float z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double getX() {
            return (double) x;
        }

        public double getY() {
            return (double) y;
        }

        public double getZ() {
        	return (double) z;
        }
        
        public void setLocation(double x, double y, double z) {
            this.x = (float) x;
            this.y = (float) y;
            this.z = (float) z;
        }


        public void setLocation(float x, float y, float z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public String toString() {
            return "Point3DAbstract.Float["+x+", "+y+"," +z+"]";
        }

    }

    public static class Double extends Point3DAbstract {

        public double x;
        public double y;
        public double z;
        
        public Double() {}

        public Double(double x, double y, double z) {
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

        public void setLocation(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public String toString() {
            return "Point3DAbstract.Double["+x+", "+y+","+z+"]";
        }

    }


    protected Point3DAbstract() {}

    public abstract double getX();
    public abstract double getY();
    public abstract double getZ();
    
    public abstract void setLocation(double x, double y, double z);

    public void setLocation(Point3DAbstract p) {
        setLocation(p.getX(), p.getY(), p.getZ());
    }

    public static double distanceSq(double x1, double y1, double z1,
                                    double x2, double y2, double z2)
    {
        x1 -= x2;
        y1 -= y2;
        z1 -= z2;
        return (x1 * x1 + y1 * y1 + z1 * z1);
    }

    public static double distance(double x1, double y1, double z1,
                                  double x2, double y2, double z2)
    {
        x1 -= x2;
        y1 -= y2;
        z1 -= z2;
        return Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1);
    }

    public double distanceSq(double px, double py, double pz) {
        px -= getX();
        py -= getY();
        pz -= getZ();
        return (px * px + py * py + pz * pz);
    }

    public double distanceSq(Point3DAbstract pt) {
        double px = pt.getX() - this.getX();
        double py = pt.getY() - this.getY();
        double pz = pt.getZ() - this.getZ();
        return (px * px + py * py + pz * pz);
    }

    public double distance(double px, double py, double pz) {
        px -= getX();
        py -= getY();
        pz -= getZ();
        return Math.sqrt(px * px + py * py + pz * pz);
    }

    public double distance(Point3DAbstract pt) {
        double px = pt.getX() - this.getX();
        double py = pt.getY() - this.getY();
        double pz = pt.getZ() - this.getZ();
        return Math.sqrt(px * px + py * py + pz * pz);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // should never happen
            throw new InternalError(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof Point3DAbstract) {
            Point3DAbstract p3d = (Point3DAbstract) obj;
            return (getX() == p3d.getX()) && (getY() == p3d.getY() && (getZ() == p3d.getZ()));
        }
        return super.equals(obj);
    }
}

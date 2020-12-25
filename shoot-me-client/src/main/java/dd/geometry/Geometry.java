package dd.geometry;

public class Geometry {

    public static Geometry UP = new Geometry(0, -1);
    public static Geometry DOWN = new Geometry(0, 1);
    public static Geometry LEFT = new Geometry(-1, 0);
    public static Geometry RIGHT = new Geometry(1, 0);

    private double x;
    private double y;

    public Geometry(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Geometry addCords(double x, double y) {
        return new Geometry(this.x + x, this.y + y);
    }

    public Geometry add(Geometry geometry) {
        return new Geometry(this.x + geometry.getX(), this.y + geometry.getY());
    }

    public Geometry subtract(Geometry geometry) {
        return new Geometry(this.x - geometry.getX(), this.y - geometry.getY());
    }

    public static double getDistance(Geometry pos1, Geometry pos2) {
        double x = pos2.x - pos1.x;
        double y = pos2.y - pos1.y;
        return Math.sqrt(x * x + y * y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Geometry{" + "x=" + x + ", y=" + y + '}';
    }
}

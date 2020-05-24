package dd.geometry;

public class Geometry {

    public static Geometry UP = new Geometry(0, -1);
    public static Geometry DOWN = new Geometry(0, 1);
    public static Geometry LEFT = new Geometry(-1, 0);
    public static Geometry RIGHT = new Geometry(1, 0);

    private int x;
    private int y;

    public Geometry(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Geometry addCords(int x, int y) {
        return new Geometry(this.x + x, this.y + y);
    }

    public static double getDistance(Geometry pos1, Geometry pos2) {
        int x = pos2.x - pos1.x;
        int y = pos2.y - pos1.y;
        return Math.sqrt(x * x + y * y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

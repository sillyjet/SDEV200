public class RegularPolygon {
    private int n = 3;
    private double side = 1;
    private double x = 0;
    private double y = 0;

    public RegularPolygon() {

    }

    public RegularPolygon(int n, double side) {
        if (side <= 0) {
            throw new IllegalArgumentException();
        }
        if (n < 3) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        this.side = side;
    }

    public RegularPolygon(int n, double side, double x, double y) {
        this(n, side);
        this.x = x;
        this.y = y;
    }

    public int getN() {
        return n;
    }

    public double getSide() {
        return side;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setN(int n) {
        if (n < 3) {
            throw new IllegalArgumentException();
        }
        this.n = n;
    }

    public void setSide(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException();
        }
        this.side = side;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getPerimeter() {
        return n * side;
    }

    public double getArea() {
        return (n * side * side) / (4 * Math.tan(Math.PI / n));
    }

    public static void main(String[] args) {
        RegularPolygon Triangle = new RegularPolygon();
        RegularPolygon Hexagon = new RegularPolygon(6, 4);
        RegularPolygon Decagon = new RegularPolygon(10, 4, 5.6, 7.8);
        System.out.println(Triangle.getPerimeter());
        System.out.println(Triangle.getArea());
        System.out.println(Hexagon.getPerimeter());
        System.out.println(Hexagon.getArea());
        System.out.println(Decagon.getPerimeter());
        System.out.println(Decagon.getArea());
    }
}

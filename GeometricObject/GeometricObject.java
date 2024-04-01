import java.util.Scanner;

// GeometricObject.java: The abstract GeometricObject class
public abstract class GeometricObject {
  private String color = "white";
  private boolean filled;

  /**Default construct*/
  protected GeometricObject() {
  }

  /**Construct a geometric object*/
  protected GeometricObject(String color, boolean filled) {
    this.color = color;
    this.filled = filled;
  }

  /**Getter method for color*/
  public String getColor() {
    return color;
  }

  /**Setter method for color*/
  public void setColor(String color) {
    this.color = color;
  }

  /**Getter method for filled. Since filled is boolean,
     so, the get method name is isFilled*/
  public boolean isFilled() {
    return filled;
  }

  /**Setter method for filled*/
  public void setFilled(boolean filled) {
    this.filled = filled;
  }

  /**Abstract method findArea*/
  public abstract double getArea();

  /**Abstract method getPerimeter*/
  public abstract double getPerimeter();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the length of the first side of your triangle:");
    double len1 = sc.nextDouble();
    System.out.println("Enter the length of the second side of your triangle:");
    double len2 = sc.nextDouble();
    System.out.println("Enter the length of the third side of your triangle:");
    double len3 = sc.nextDouble();
    System.out.println("What color is your triangle?");
    sc.nextLine();
    String col = sc.nextLine();
    System.out.println("Enter 'true' or 'false' to indicate whether or not your triangle is filled:");
    String fillString = sc.nextLine().toLowerCase();
    Boolean fillBool = null;
    Boolean flag = false;
    while (flag == false) {
        if (fillString.equals("true") || fillString.equals("false")) {
            fillBool = Boolean.parseBoolean(fillString);
            flag = true;
        } else {
            System.out.println("Error! You must enter either 'true' or 'false' for this value. Please try again:");
            fillString = sc.nextLine().toLowerCase();
        }
    }
    sc.close();
    Triangle myTriangle = new Triangle(len1, len2, len3);
    myTriangle.setColor(col);
    myTriangle.setFilled(fillBool);
    System.out.println("Triangle area: " + myTriangle.getArea());
    System.out.println("Triangle perimeter: " + myTriangle.getPerimeter());
    System.out.println("Triangle color: " + myTriangle.getColor());
    System.out.println("Triangle filled: " + myTriangle.isFilled());
}

  static class Triangle extends GeometricObject {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle() {
    
    }

    public Triangle(double side1, double side2, double side3) {
        if (side1 <= 0) {
            throw new IllegalArgumentException();
        }
        if (side2 <= 0) {
            throw new IllegalArgumentException();
        }
        if (side3 <= 0) {
            throw new IllegalArgumentException();
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide1(double side1) {
        if (side1 <= 0) {
            throw new IllegalArgumentException();
        }
        this.side1 = side1;
    }

    public void setSide2(double side2) {
        if (side2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.side2 = side2;
    }

    public void setSide3(double side3) {
        if (side3 <= 0) {
            throw new IllegalArgumentException();
        }
        this.side3 = side3;
    }
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }
}
}

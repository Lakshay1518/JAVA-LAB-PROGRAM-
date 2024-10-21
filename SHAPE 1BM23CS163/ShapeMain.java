import java.util.Scanner;


abstract class Shape {
    protected int dimension1;
    protected int dimension2;

    public Shape(int dimension1, int dimension2) {
        this.dimension1 = dimension1;
        this.dimension2 = dimension2;
    }

    public abstract void printArea();
}


class Rectangle extends Shape {
    public Rectangle(int length, int width) {
        super(length, width);
    }

    @Override
    public void printArea() {
        int area = dimension1 * dimension2;
        System.out.println("Area of Rectangle: " + area);
    }
}


class Triangle extends Shape {
    public Triangle(int base, int height) {
        super(base, height);
    }

    @Override
    public void printArea() {
        double area = 0.5 * dimension1 * dimension2;
        System.out.println("Area of Triangle: " + area);
    }
}


class Circle extends Shape {
    public Circle(int radius) {
        super(radius, 0); // Only radius is used, so dimension2 is set to 0
    }

    @Override
    public void printArea() {
        double area = Math.PI * dimension1 * dimension1;
        System.out.println("Area of Circle: " + area);
    }
}


public class ShapeMain { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the length of the rectangle: ");
        int length = scanner.nextInt();
        System.out.print("Enter the width of the rectangle: ");
        int width = scanner.nextInt();
        Shape rectangle = new Rectangle(length, width);
        rectangle.printArea();

        
        System.out.print("Enter the base of the triangle: ");
        int base = scanner.nextInt();
        System.out.print("Enter the height of the triangle: ");
        int height = scanner.nextInt();
        Shape triangle = new Triangle(base, height);
        triangle.printArea();

        
        System.out.print("Enter the radius of the circle: ");
        int radius = scanner.nextInt();
        Shape circle = new Circle(radius);
        circle.printArea();

        
        scanner.close();
    }
}
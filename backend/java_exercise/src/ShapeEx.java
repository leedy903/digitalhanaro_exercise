import java.util.Arrays;

abstract class Shape {
    abstract double calArea();
}

class Circle1 extends Shape {
    double radius;

    public Circle1(double radius) {
        this.radius = radius;
    }

    double calArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    double calArea() {
        return width * height;
    }
}

public class ShapeEx {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle1(5.0), new Rectangle(3, 4), new Circle1(1)};
        double areaSum = 0;
        for (Shape shape : shapes) {
            areaSum += shape.calArea();
        }
        System.out.println("면적의 합: " + areaSum);
        System.out.println("면적의 합: " + Arrays.stream(shapes).mapToDouble(Shape::calArea).sum());
    }
}

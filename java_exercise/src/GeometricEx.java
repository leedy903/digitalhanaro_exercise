interface GeometricObejct {
    double getPerimeter();
    double getArea();

}

class Circle implements GeometricObejct {
    double radius = 1.0;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle[" +
                "radius=" + radius +
                "]"  + "의 둘레는 " + String.format("%.1f", this.getPerimeter()) +
                ", 면적은 " + String.format("%.1f", this.getArea());
    }
}

interface Resizable {
    void resize(int percent);
}

class ResizableCircle extends Circle implements Resizable {

    public ResizableCircle(double radius) {
        super(radius);
    }

    @Override
    public void resize(int percent) {
        setRadius(getRadius() + getRadius() * percent/100);
    }

    @Override
    public String toString() {
        return "ResizableCircle[" +
                "radius=" + radius +
                "]"  + "의 둘레는 " + String.format("%.1f", this.getPerimeter()) +
                ", 면적은 " + String.format("%.1f", this.getArea());
    }
}


public class GeometricEx {
    public static void main(String[] args) {
        Circle circle = new Circle(2);
        System.out.println(circle);
        System.out.println("----------------------------------------------------");

        ResizableCircle resizableCircle = new ResizableCircle(3);
        System.out.println(resizableCircle);
        System.out.println("----------------------------------------------------");

        System.out.println("크기를 10페선트 크게 변경 후");
        resizableCircle.resize(10);
        System.out.println(resizableCircle);
    }
}

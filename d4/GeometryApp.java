package d4;

public class GeometryApp {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        System.out.println("Площадь круга: " + circle.getArea());
        System.out.println("Периметр круга: " + circle.getPerimeter());

        Rectangle rectangle = new Rectangle(4.0, 6.0);
        System.out.println("Площадь прямоугольника: " + rectangle.getArea());
        System.out.println("Периметр прямоугольника: " + rectangle.getPerimeter());

        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        System.out.println("Площадь треугольника: " + triangle.getArea());
        System.out.println("Периметр треугольника: " + triangle.getPerimeter());

        Shape circle1 = new Circle(5);
        System.out.println("Площадь круга: " + circle1.getArea());
        System.out.println("Периметр круга: " + circle1.getPerimeter());

        Shape rectangle1 = new Rectangle(4.0, 6.0);
        System.out.println("Площадь прямоугольника: " + rectangle1.getArea());
        System.out.println("Периметр прямоугольника: " + rectangle1.getPerimeter());

        Shape triangle1 = new Triangle(3.0, 4.0, 5.0);
        System.out.println("Площадь треугольника: " + triangle1.getArea());
        System.out.println("Периметр треугольника: " + triangle1.getPerimeter());

    }
}



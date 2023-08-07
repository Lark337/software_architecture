package d4;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    
    /** 
     * @param radius радиус круга
     * @return площадь круга 
     */
    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }

    
    /** 
     * @param radius радиус круга
     * @return периметр круга
     */
    @Override
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

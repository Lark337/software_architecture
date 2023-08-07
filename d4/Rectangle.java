package d4;

public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    
    /** 
     * @param lenght длина
     * @param width ширина
     * @return double
     */
    @Override
    double getArea() {
        return length * width;
    }

    
    /** 
     * @param lenght длина
     * @param width ширина
     * @return периметр прямоугольника 
     */
    @Override
    double getPerimeter() {
        return 2 * (length + width);
    }
}

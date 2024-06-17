//Create an abstract class Shape with abstract methods area and perimeter. Implement
//classes Circle and Rectangle that inherit from Shape. Provide different
//implementations for calculating the area and perimeter in each subclass.
import java.util.Scanner;
abstract class shape {
    abstract double area();
    abstract double perimeter();
}
class Circle extends shape{
    double area(double rad) {
        double carea=3.14*rad;
        return carea;
    }
    double perimeter(double rad) {
        double cperimeter=(2*3.14)*rad;
        return cperimeter;
    }

    @Override
    double area() {
        return 0;
    }

    @Override
    double perimeter() {
        return 0;
    }
}
class Reactangle extends shape{
    double l,b;
    double area(double l,double b) {
        double rarea=l*b;
        return rarea;
    }
    double perimeter(double l,double b) {
        double rperimeter=2*(l+b);
        return rperimeter;
    }

    @Override
    double area() {
        return 0;
    }

    @Override
    double perimeter() {
        return 0;
    }
}
class calculate{
    public static void main(String[] args) {

            Scanner n= new Scanner(System.in);
            System.out.println("Enter the radius of the circle");
            double Re= n.nextDouble();
            System.out.println("Enter the length of rectangle");
            double le= n.nextDouble();
            System.out.println("Enter the breadth of rectangle");

        double br=n.nextDouble();
        Circle c=new Circle();

        Reactangle r= new Reactangle();
        double r_area=r.area(le,br);
        double r_perimeter=r.perimeter(le,br);
        double c_perimeter=c.perimeter(Re);
        double c_area=c.area(Re);

        System.out.println("Area of circle="+c_area);
        System.out.println("Perimeter of circle="+c_perimeter);
        System.out.println("Area of rectangle="+r_area);
        System.out.println("Perimeter of rectangle="+r_perimeter);
    }


}


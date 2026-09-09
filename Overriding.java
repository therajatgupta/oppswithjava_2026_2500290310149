public class Overriding {
    public static void main(String[] args) {
        Shape obj1 = new Circle(49);
        Shape obj2 = new Rectangle(5, 10);
        obj1.area(); 
        obj2.area();
        Shape[] obj3 = {new Circle(7.0), new Rectangle(10, 20)};
        for(Shape i:obj3) i.area();

    }
}

class Shape{
    void area(){

    }
}
class Circle extends Shape{
    private double r;

    public Circle(double r){
        this.r =r ;
    }
    void area(){
        System.out.println("Area of Circle is " + (22/7.0*r*r));
    }
}
class Rectangle extends  Shape{
    private int l,b;

    Rectangle(int l, int b){
        this.l = l;
        this.b = b;
    }

    void area(){
        System.out.println("Area of Rectangle: " + (l*b));
    }
}
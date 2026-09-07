/*
 * Polymorphism:
 *  - Compile-time (static) polymorphism: method overloading.
 *  - Runtime (dynamic) polymorphism: method overriding + upcasting,
 *    where the actual method invoked depends on the object's real type at runtime.
 */
public class Polymorphism {

    static class Shape {
        double area() { return 0; }
    }
    static class Circle extends Shape {
        double radius;
        Circle(double r) { radius = r; }
        @Override double area() { return Math.PI * radius * radius; }
    }
    static class Rectangle extends Shape {
        double w, h;
        Rectangle(double w, double h) { this.w = w; this.h = h; }
        @Override double area() { return w * h; }
    }

    // overloading = compile-time polymorphism
    static void describe(int n) { System.out.println("An int: " + n); }
    static void describe(String s) { System.out.println("A string: " + s); }

    public static void main(String[] args) {
        // Runtime polymorphism: same reference type (Shape), different behavior per actual object
        Shape[] shapes = { new Circle(2), new Rectangle(3, 4) };
        for (Shape s : shapes) {
            System.out.println(s.getClass().getSimpleName() + " area = " + s.area());
        }

        describe(5);
        describe("hello");
    }
}

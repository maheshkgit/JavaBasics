/*
 * Methods: declaration, parameters, return types, overloading, varargs, static vs instance
 */
public class Methods {

    // instance method
    int square(int n) {
        return n * n;
    }

    // static method - belongs to the class, not an instance
    static int cube(int n) {
        return n * n * n;
    }

    // method overloading - same name, different parameter lists
    static double add(int a, int b) {
        return a + b;
    }
    static double add(double a, double b) {
        return a + b;
    }
    static double add(int a, int b, int c) {
        return a + b + c;
    }

    // varargs - accepts a variable number of arguments
    static int sumAll(int... values) {
        int total = 0;
        for (int v : values) total += v;
        return total;
    }

    public static void main(String[] args) {
        Methods m = new Methods();
        System.out.println("square(5) = " + m.square(5));          // instance method call
        System.out.println("cube(3) = " + Methods.cube(3));        // static method call

        System.out.println("add(2,3) = " + add(2, 3));
        System.out.println("add(2.5,3.5) = " + add(2.5, 3.5));
        System.out.println("add(1,2,3) = " + add(1, 2, 3));

        System.out.println("sumAll() = " + sumAll());
        System.out.println("sumAll(1,2,3,4) = " + sumAll(1, 2, 3, 4));
    }
}

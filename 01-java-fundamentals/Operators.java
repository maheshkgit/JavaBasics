/*
 * Operators: arithmetic, relational, logical, bitwise, assignment, ternary
 */
public class Operators {
    public static void main(String[] args) {
        int a = 10, b = 3;

        // Arithmetic
        System.out.println("a+b=" + (a + b));
        System.out.println("a-b=" + (a - b));
        System.out.println("a*b=" + (a * b));
        System.out.println("a/b=" + (a / b));   // integer division -> 3
        System.out.println("a%b=" + (a % b));   // remainder -> 1

        // Relational
        System.out.println("a>b: " + (a > b));
        System.out.println("a==b: " + (a == b));

        // Logical
        boolean x = true, y = false;
        System.out.println("x && y: " + (x && y));
        System.out.println("x || y: " + (x || y));
        System.out.println("!x: " + (!x));

        // Bitwise
        System.out.println("a & b = " + (a & b));
        System.out.println("a | b = " + (a | b));
        System.out.println("a ^ b = " + (a ^ b));
        System.out.println("~a = " + (~a));
        System.out.println("a << 1 = " + (a << 1));
        System.out.println("a >> 1 = " + (a >> 1));

        // Assignment operators
        int c = 5;
        c += 3; System.out.println("c+=3 -> " + c);
        c *= 2; System.out.println("c*=2 -> " + c);

        // Ternary
        int max = (a > b) ? a : b;
        System.out.println("max = " + max);
    }
}

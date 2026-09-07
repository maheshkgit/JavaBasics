/*
 * Functional Interfaces
 * ------------------------
 * An interface with exactly ONE abstract method (SAM). Can have default/static methods too.
 * @FunctionalInterface is optional but enforces the single-abstract-method rule at compile time.
 * java.util.function package provides many ready-made ones (Predicate, Function, Consumer, Supplier, etc.)
 */
public class FunctionalInterfaces {

    // Custom functional interface
    @FunctionalInterface
    interface Calculator {
        int operate(int a, int b);

        // default methods are allowed - don't count toward the "single abstract method" rule
        default void printResult(int a, int b) {
            System.out.println("Result = " + operate(a, b));
        }

        // static methods are also allowed
        static Calculator addition() {
            return (x, y) -> x + y;
        }
    }

    // Extending a functional interface - still valid as long as ONE abstract method total
    @FunctionalInterface
    interface AdvancedCalculator extends Calculator {
        // inherits 'operate' as its single abstract method
    }

    public static void main(String[] args) {
        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;

        System.out.println("add(3,4) = " + add.operate(3, 4));
        System.out.println("subtract(10,4) = " + subtract.operate(10, 4));
        System.out.println("multiply(3,4) = " + multiply.operate(3, 4));

        add.printResult(5, 6); // uses default method

        Calculator staticAdd = Calculator.addition();
        System.out.println("via static factory: " + staticAdd.operate(1, 2));

        AdvancedCalculator adv = (a, b) -> a * a + b * b;
        System.out.println("advanced(3,4) = " + adv.operate(3, 4));

        // Uncommenting a second abstract method below would break @FunctionalInterface compilation:
        // interface Broken { int op1(int a); int op2(int a); } // ERROR if annotated @FunctionalInterface
    }
}

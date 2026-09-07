/*
 * Interfaces: a contract of methods a class must implement. Supports multiple inheritance
 * of type. Since Java 8, interfaces can have default and static methods.
 */
public class Interfaces {

    interface Flyable {
        void fly(); // abstract by default

        default void land() { // default method - has a body, optional to override
            System.out.println("Landing safely.");
        }

        static Flyable createDefault() { // static factory method on the interface
            return () -> System.out.println("Generic flying object flies.");
        }
    }

    interface Swimmable {
        void swim();
    }

    // A class can implement multiple interfaces (multiple inheritance of type)
    static class Duck implements Flyable, Swimmable {
        @Override public void fly() { System.out.println("Duck flies."); }
        @Override public void swim() { System.out.println("Duck swims."); }
    }

    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.fly();
        duck.swim();
        duck.land(); // inherited default method

        Flyable generic = Flyable.createDefault();
        generic.fly();

        // Lambda expressions can implement a functional interface (single abstract method)
        Flyable lambdaFlyer = () -> System.out.println("Lambda-based flyer flies!");
        lambdaFlyer.fly();
    }
}

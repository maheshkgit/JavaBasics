/*
 * Composition vs Inheritance
 * -----------------------------
 * Inheritance = "is-a" relationship (tight coupling, subclass depends on superclass internals).
 * Composition = "has-a" relationship (an object holds a reference to another object and
 *               delegates work to it) - generally more flexible ("favor composition over inheritance").
 */
public class CompositionVsInheritance {

    // --- Inheritance approach ---
    static class Engine {
        void start() { System.out.println("Engine starting..."); }
    }
    // Bad: Car "is-a" Engine doesn't really make sense semantically
    static class CarInherits extends Engine {
        void drive() {
            start(); // inherited, but weird conceptually
            System.out.println("Car is driving (via inheritance).");
        }
    }

    // --- Composition approach (preferred here) ---
    static class CarComposed {
        private final Engine engine; // "has-a" engine

        CarComposed(Engine engine) {
            this.engine = engine;
        }

        void drive() {
            engine.start();          // delegate to the composed object
            System.out.println("Car is driving (via composition).");
        }
    }

    public static void main(String[] args) {
        new CarInherits().drive();

        CarComposed car = new CarComposed(new Engine());
        car.drive();
    }
}

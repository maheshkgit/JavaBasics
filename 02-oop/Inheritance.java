/*
 * Inheritance: a class (subclass) acquires fields/methods from another class (superclass),
 * modeling an "is-a" relationship, and can override/extend behavior.
 */
public class Inheritance {

    static class Animal {
        String name;
        Animal(String name) { this.name = name; }

        void eat() {
            System.out.println(name + " is eating.");
        }

        void makeSound() {
            System.out.println(name + " makes a generic sound.");
        }
    }

    static class Dog extends Animal {
        Dog(String name) {
            super(name); // call superclass constructor
        }

        @Override
        void makeSound() {
            System.out.println(name + " barks: Woof!");
        }

        void fetch() {
            System.out.println(name + " fetches the ball.");
        }
    }

    public static void main(String[] args) {
        Dog d = new Dog("Rex");
        d.eat();        // inherited from Animal
        d.makeSound();  // overridden in Dog
        d.fetch();      // defined only in Dog
    }
}

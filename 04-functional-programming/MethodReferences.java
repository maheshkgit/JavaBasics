/*
 * Method References
 * --------------------
 * Shorthand for a lambda that just calls an existing method. Four forms:
 *  1. Static method:                    Type::staticMethod
 *  2. Instance method of a particular object:  obj::instanceMethod
 *  3. Instance method of an arbitrary object of a type: Type::instanceMethod
 *  4. Constructor reference:            Type::new
 */
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.BiFunction;
import java.util.List;
import java.util.ArrayList;

public class MethodReferences {

    static class Person {
        String name;
        Person(String name) { this.name = name; }
        String getName() { return name; }
        @Override public String toString() { return "Person(" + name + ")"; }
    }

    public static void main(String[] args) {
        // 1. Static method reference
        Function<String, Integer> parse = Integer::parseInt;   // equiv to: s -> Integer.parseInt(s)
        System.out.println("parse.apply(\"42\"): " + parse.apply("42"));

        // 2. Instance method of a particular, existing object
        String greeting = "Hello, World!";
        Supplier<Integer> lengthOfGreeting = greeting::length; // equiv to: () -> greeting.length()
        System.out.println("lengthOfGreeting.get(): " + lengthOfGreeting.get());

        // 3. Instance method of an ARBITRARY object of a given type (object becomes the first arg)
        Function<String, Integer> length = String::length;     // equiv to: s -> s.length()
        System.out.println("length.apply(\"test\"): " + length.apply("test"));

        BiFunction<String, String, Boolean> startsWith = String::startsWith; // equiv to: (s, prefix) -> s.startsWith(prefix)
        System.out.println("startsWith.apply(\"hello\", \"he\"): " + startsWith.apply("hello", "he"));

        // 4. Constructor reference
        Supplier<List<String>> newList = ArrayList::new;        // equiv to: () -> new ArrayList<>()
        List<String> list = newList.get();
        list.add("created via constructor reference");
        System.out.println(list);

        Function<String, Person> personFactory = Person::new;   // equiv to: name -> new Person(name)
        Person p = personFactory.apply("Mah");
        System.out.println(p);

        // Real-world use: sorting/mapping with method references instead of verbose lambdas
        List<Person> people = List.of(new Person("Charlie"), new Person("Alice"), new Person("Bob"));
        people.stream()
                .map(Person::getName)      // instance method of arbitrary object
                .sorted(String::compareTo) // instance method of arbitrary object
                .forEach(System.out::println); // instance method of particular object (System.out)
    }
}

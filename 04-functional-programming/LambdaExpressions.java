/*
 * Lambda Expressions
 * --------------------
 * A lambda is a concise anonymous function: (params) -> expression/body.
 * It can only be used where a functional interface (single abstract method) is expected.
 * Local variables captured by a lambda must be "effectively final".
 */
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class LambdaExpressions {

    interface Greeter {
        String greet(String name);
    }

    public static void main(String[] args) {
        // No-arg lambda
        Runnable task = () -> System.out.println("Task running!");
        task.run();

        // Single expression lambda (implicit return)
        Greeter g1 = name -> "Hello, " + name + "!";
        System.out.println(g1.greet("Mah"));

        // Block-body lambda with explicit return
        Greeter g2 = (name) -> {
            String upper = name.toUpperCase();
            return "HI " + upper;
        };
        System.out.println(g2.greet("world"));

        // Lambda capturing an effectively-final local variable
        String prefix = "User: ";
        Greeter g3 = name -> prefix + name;
        System.out.println(g3.greet("Alice"));
        // prefix = "changed"; // if uncommented, compile error: prefix must be effectively final

        // Lambdas as Comparators - classic sorting use case
        List<String> names = new ArrayList<>(List.of("Charlie", "Al", "Bob"));
        names.sort((a, b) -> a.length() - b.length()); // sort by length
        System.out.println("Sorted by length: " + names);

        names.sort(Comparator.reverseOrder());
        System.out.println("Reverse alphabetical: " + names);
    }
}

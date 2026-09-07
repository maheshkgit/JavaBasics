/*
 * Consumer<T>: void accept(T t)
 * Takes an input, performs a side effect (e.g., printing, saving), returns nothing.
 * Chainable with andThen() - both run in sequence on the same input.
 */
import java.util.function.Consumer;
import java.util.function.BiConsumer;
import java.util.List;
import java.util.Map;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> printUpper = s -> System.out.println("UPPER: " + s.toUpperCase());
        Consumer<String> printLength = s -> System.out.println("LENGTH: " + s.length());

        // andThen - chain two consumers to run on the same input, in order
        Consumer<String> combined = printUpper.andThen(printLength);
        combined.accept("hello");

        // Real-world use: List.forEach takes a Consumer
        List<String> items = List.of("apple", "banana", "cherry");
        items.forEach(item -> System.out.println("Item: " + item));

        // Method reference as a Consumer
        items.forEach(System.out::println);

        // BiConsumer - two inputs, e.g. Map.forEach(key, value)
        Map<String, Integer> prices = Map.of("Apple", 2, "Banana", 1);
        BiConsumer<String, Integer> printEntry = (name, price) -> System.out.println(name + " costs $" + price);
        prices.forEach(printEntry);
    }
}

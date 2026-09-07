/*
 * Predicate<T>: boolean test(T t)
 * Represents a condition/filter on a single input. Combine with and(), or(), negate().
 */
import java.util.function.Predicate;
import java.util.List;
import java.util.stream.Collectors;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isPositive = n -> n > 0;

        System.out.println("isEven.test(4): " + isEven.test(4));
        System.out.println("isEven.test(5): " + isEven.test(5));

        // Combinators
        Predicate<Integer> isEvenAndPositive = isEven.and(isPositive);
        Predicate<Integer> isEvenOrPositive = isEven.or(isPositive);
        Predicate<Integer> isOdd = isEven.negate();

        System.out.println("isEvenAndPositive.test(-4): " + isEvenAndPositive.test(-4)); // false
        System.out.println("isEvenAndPositive.test(4): " + isEvenAndPositive.test(4));   // true
        System.out.println("isEvenOrPositive.test(-3): " + isEvenOrPositive.test(-3));   // false
        System.out.println("isOdd.test(3): " + isOdd.test(3));                            // true

        // Real-world use: filtering a list
        List<Integer> nums = List.of(-4, -3, -2, -1, 0, 1, 2, 3, 4, 5);
        List<Integer> filtered = nums.stream()
                .filter(isEvenAndPositive)
                .collect(Collectors.toList());
        System.out.println("Even and positive numbers: " + filtered);

        // BiPredicate - two arguments
        java.util.function.BiPredicate<String, Integer> lengthMatches = (s, len) -> s.length() == len;
        System.out.println("lengthMatches('hello', 5): " + lengthMatches.test("hello", 5));

        // Predicate.isEqual static factory
        Predicate<String> equalsHello = Predicate.isEqual("hello");
        System.out.println("equalsHello.test('hello'): " + equalsHello.test("hello"));
    }
}

/*
 * Streams
 * ---------
 * A sequence of elements supporting functional-style operations. Not a data structure -
 * doesn't store data, is typically lazy, and can only be consumed (terminal op) ONCE.
 *
 * Intermediate ops (lazy, return a new Stream): filter, map, flatMap, sorted, distinct, limit, skip, peek
 * Terminal ops (trigger execution, produce a result): collect, forEach, reduce, count, anyMatch, min/max
 */
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.IntStream;

public class StreamsDemo {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "Dave", "Eve");

        // filter + map + sorted + collect
        List<String> result = names.stream()
                .filter(n -> n.length() > 3)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Filtered/mapped/sorted: " + result);

        // reduce - combine elements into a single result
        int totalLength = names.stream()
                .mapToInt(String::length)
                .reduce(0, Integer::sum);
        System.out.println("Total length of all names: " + totalLength);

        // count, anyMatch, allMatch
        long countLongNames = names.stream().filter(n -> n.length() > 4).count();
        System.out.println("Names longer than 4 chars: " + countLongNames);
        System.out.println("Any name starts with 'A'? " + names.stream().anyMatch(n -> n.startsWith("A")));
        System.out.println("All names longer than 2 chars? " + names.stream().allMatch(n -> n.length() > 2));

        // flatMap - flatten nested collections into a single stream
        List<List<Integer>> nested = List.of(List.of(1, 2), List.of(3, 4), List.of(5));
        List<Integer> flat = nested.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("Flattened: " + flat);

        // Collectors.groupingBy - group elements by a classifier
        var byFirstLetter = names.stream()
                .collect(Collectors.groupingBy(n -> n.charAt(0)));
        System.out.println("Grouped by first letter: " + byFirstLetter);

        // Collectors.joining
        String joined = names.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Joined: " + joined);

        // IntStream for numeric ranges
        int sumOfSquares = IntStream.rangeClosed(1, 5)
                .map(n -> n * n)
                .sum();
        System.out.println("Sum of squares 1..5: " + sumOfSquares);

        // Streams are single-use - this would throw IllegalStateException:
        Stream<String> onceOnly = names.stream();
        onceOnly.forEach(System.out::println);
        try {
            onceOnly.count(); // reusing a consumed stream
        } catch (IllegalStateException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }
    }
}

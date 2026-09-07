/*
 * Optional<T>
 * -------------
 * A container that may or may not hold a non-null value. Used as a RETURN TYPE to signal
 * "value might be absent" explicitly, instead of returning null and risking NullPointerException.
 * Anti-pattern: using Optional as a field type or method parameter.
 */
import java.util.Optional;

public class OptionalDemo {

    static Optional<String> findUserById(int id) {
        if (id == 1) return Optional.of("Alice");
        return Optional.empty(); // explicit "not found", no null returned
    }

    public static void main(String[] args) {
        Optional<String> found = findUserById(1);
        Optional<String> notFound = findUserById(99);

        System.out.println("isPresent(found): " + found.isPresent());
        System.out.println("isEmpty(notFound): " + notFound.isEmpty());

        // orElse vs orElseGet vs orElseThrow
        System.out.println("found.orElse(default): " + found.orElse("DEFAULT"));
        System.out.println("notFound.orElse(default): " + notFound.orElse("DEFAULT"));
        System.out.println("notFound.orElseGet(supplier): " + notFound.orElseGet(() -> "computed default"));

        try {
            notFound.orElseThrow(() -> new IllegalStateException("User not found!"));
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // map - transform the value if present, stays empty if absent
        Optional<Integer> length = found.map(String::length);
        System.out.println("found.map(length): " + length);
        Optional<Integer> emptyLength = notFound.map(String::length); // no NPE, just stays empty
        System.out.println("notFound.map(length): " + emptyLength);

        // filter - keep the value only if it matches a predicate
        Optional<String> longName = found.filter(n -> n.length() > 10);
        System.out.println("found.filter(length>10): " + longName);

        // ifPresent / ifPresentOrElse
        found.ifPresent(name -> System.out.println("Found user: " + name));
        notFound.ifPresentOrElse(
                name -> System.out.println("Found user: " + name),
                () -> System.out.println("No user found, running fallback action")
        );

        // Optional.of() vs Optional.ofNullable()
        try {
            Optional.of(null); // throws immediately
        } catch (NullPointerException e) {
            System.out.println("Optional.of(null) threw NPE as expected");
        }
        Optional<String> safe = Optional.ofNullable(null); // wraps safely into empty
        System.out.println("Optional.ofNullable(null): " + safe);
    }
}

/*
 * Supplier<T>: T get()
 * Takes no input, produces (supplies) a value. Useful for lazy/deferred evaluation.
 */
import java.util.function.Supplier;
import java.util.Optional;

public class SupplierDemo {

    static String expensiveDefault() {
        System.out.println("  (computing expensive default...)");
        return "EXPENSIVE_DEFAULT";
    }

    public static void main(String[] args) {
        Supplier<Double> randomValue = Math::random;
        System.out.println("Random: " + randomValue.get());
        System.out.println("Random again (recomputed each call): " + randomValue.get());

        // Lazy initialization pattern
        Supplier<StringBuilder> lazyBuilder = StringBuilder::new;
        StringBuilder sb = lazyBuilder.get();
        sb.append("built lazily");
        System.out.println(sb);

        // Real-world value: Optional.orElseGet only calls the Supplier if needed
        Optional<String> present = Optional.of("actual value");
        System.out.println("orElseGet when present (supplier NOT called):");
        System.out.println(present.orElseGet(SupplierDemo::expensiveDefault));

        Optional<String> empty = Optional.empty();
        System.out.println("orElseGet when empty (supplier IS called):");
        System.out.println(empty.orElseGet(SupplierDemo::expensiveDefault));

        // Contrast with orElse, which ALWAYS evaluates its argument eagerly
        System.out.println("orElse when present (argument evaluated anyway):");
        System.out.println(present.orElse(expensiveDefault()));
    }
}

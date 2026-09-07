/*
 * Set interface: a collection that contains NO DUPLICATE elements.
 * Common implementations: HashSet (no order), LinkedHashSet (insertion order),
 * TreeSet (sorted order).
 */
import java.util.Set;
import java.util.HashSet;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Alice"); // duplicate - ignored silently

        System.out.println("Set (duplicates ignored): " + names);
        System.out.println("Size: " + names.size()); // 2, not 3
        System.out.println("Contains Bob: " + names.contains("Bob"));

        Set<Integer> a = new HashSet<>(Set.of(1, 2, 3, 4));
        Set<Integer> b = new HashSet<>(Set.of(3, 4, 5, 6));

        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);
        System.out.println("Union: " + union);

        Set<Integer> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        System.out.println("Intersection: " + intersection);

        Set<Integer> difference = new HashSet<>(a);
        difference.removeAll(b);
        System.out.println("Difference (a - b): " + difference);
    }
}

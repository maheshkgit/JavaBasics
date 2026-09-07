/*
 * TreeSet: backed by a Red-Black tree (a NavigableSet). Elements are stored in
 * SORTED order (natural ordering or a supplied Comparator). O(log n) operations.
 */
import java.util.TreeSet;
import java.util.Comparator;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(50);
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);

        System.out.println("Sorted TreeSet: " + numbers); // always sorted ascending

        System.out.println("First (smallest): " + numbers.first());
        System.out.println("Last (largest): " + numbers.last());
        System.out.println("Elements < 30 (headSet): " + numbers.headSet(30));
        System.out.println("Elements >= 30 (tailSet): " + numbers.tailSet(30));
        System.out.println("Ceiling of 25: " + numbers.ceiling(25)); // smallest >= 25
        System.out.println("Floor of 25: " + numbers.floor(25));     // largest <= 25

        // Custom ordering: descending, using a Comparator
        TreeSet<String> desc = new TreeSet<>(Comparator.reverseOrder());
        desc.add("banana");
        desc.add("apple");
        desc.add("cherry");
        System.out.println("Descending TreeSet: " + desc);
    }
}

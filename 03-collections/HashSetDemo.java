/*
 * HashSet: backed by a HashMap. Offers O(1) average add/remove/contains.
 * No guaranteed iteration order. Allows one null element.
 */
import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Dog");
        set.add("Cat");
        set.add("Bird");
        set.add(null); // HashSet allows a single null

        System.out.println("HashSet (order not guaranteed): " + set);
        System.out.println("Contains Cat: " + set.contains("Cat")); // O(1) average

        set.remove("Cat");
        System.out.println("After removing Cat: " + set);

        // Relies on hashCode()/equals() to determine uniqueness
        System.out.println("Adding duplicate 'Dog' again: " + set.add("Dog")); // returns false, already present
    }
}

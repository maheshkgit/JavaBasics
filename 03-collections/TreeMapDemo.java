/*
 * TreeMap: Red-Black tree backed Map (a NavigableMap/SortedMap). Keys are stored
 * in sorted order (natural ordering or supplied Comparator). O(log n) operations.
 * Does NOT allow null keys.
 */
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<String, Integer> scores = new TreeMap<>();
        scores.put("Charlie", 85);
        scores.put("Alice", 95);
        scores.put("Bob", 90);

        System.out.println("Sorted by key: " + scores); // Alice, Bob, Charlie

        System.out.println("First key: " + scores.firstKey());
        System.out.println("Last key: " + scores.lastKey());
        System.out.println("Entries before 'Bob' (headMap): " + scores.headMap("Bob"));
        System.out.println("Entries from 'Bob' (tailMap): " + scores.tailMap("Bob"));
        System.out.println("Higher key than 'Alice': " + scores.higherKey("Alice"));
        System.out.println("Lower key than 'Charlie': " + scores.lowerKey("Charlie"));
    }
}

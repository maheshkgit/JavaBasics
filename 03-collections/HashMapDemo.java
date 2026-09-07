/*
 * HashMap: hash-table based Map implementation. O(1) average get/put.
 * No guaranteed key ordering. Allows one null key and multiple null values.
 * NOT thread-safe.
 */
import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("Widgets", 100);
        inventory.put("Gadgets", 50);
        inventory.put(null, 5); // HashMap allows one null key

        System.out.println("HashMap (order not guaranteed): " + inventory);

        // merge() is handy for accumulating values, e.g., word counts
        inventory.merge("Widgets", 25, Integer::sum); // Widgets: 100 -> 125
        System.out.println("After merge: " + inventory.get("Widgets"));

        // compute() to transform a value in place
        inventory.compute("Gadgets", (k, v) -> v == null ? 1 : v - 10);
        System.out.println("After compute: " + inventory.get("Gadgets"));

        inventory.computeIfAbsent("NewItem", k -> 0);
        System.out.println("NewItem default: " + inventory.get("NewItem"));
    }
}

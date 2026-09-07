/*
 * List interface: an ordered collection (sequence) that allows duplicates and
 * positional (index-based) access. Common implementations: ArrayList, LinkedList, Vector.
 */
import java.util.List;
import java.util.ArrayList;

public class ListDemo {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>(); // programming to the interface
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Apple"); // duplicates allowed
        fruits.add(1, "Mango"); // insert at index 1

        System.out.println("List: " + fruits);
        System.out.println("Get index 0: " + fruits.get(0));
        System.out.println("Contains Banana: " + fruits.contains("Banana"));
        System.out.println("Index of Banana: " + fruits.indexOf("Banana"));

        fruits.remove("Apple"); // removes first occurrence
        System.out.println("After removing first 'Apple': " + fruits);

        for (String f : fruits) {
            System.out.println(" - " + f);
        }
    }
}

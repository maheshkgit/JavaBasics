/*
 * ArrayList: resizable-array implementation of List.
 *  - Fast random access (O(1) get/set by index).
 *  - Slow insert/remove in the middle (O(n), requires shifting elements).
 *  - Not synchronized (not thread-safe by default).
 */
import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            numbers.add(i * 10);
        }
        System.out.println("Initial: " + numbers);

        numbers.set(2, 999);          // O(1) - direct index access
        System.out.println("After set(2, 999): " + numbers);

        numbers.remove(Integer.valueOf(999)); // remove by VALUE (need Integer.valueOf to avoid index overload)
        System.out.println("After removing value 999: " + numbers);

        numbers.remove(0);            // remove by INDEX
        System.out.println("After removing index 0: " + numbers);

        System.out.println("Size: " + numbers.size());
        numbers.clear();
        System.out.println("After clear, isEmpty: " + numbers.isEmpty());
    }
}

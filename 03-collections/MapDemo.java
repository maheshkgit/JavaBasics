/*
 * Map interface: stores KEY -> VALUE pairs. Keys are unique; values can be duplicated.
 * Not a subtype of Collection. Common implementations: HashMap, TreeMap, LinkedHashMap.
 */
import java.util.Map;
import java.util.HashMap;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Alice", 30);
        ages.put("Bob", 25);
        ages.put("Alice", 31); // overwrites - keys are unique

        System.out.println("Map: " + ages);
        System.out.println("Alice's age: " + ages.get("Alice"));
        System.out.println("Get missing key with default: " + ages.getOrDefault("Zoe", 0));
        System.out.println("Contains key Bob: " + ages.containsKey("Bob"));
        System.out.println("Contains value 25: " + ages.containsValue(25));

        ages.putIfAbsent("Bob", 99);  // Bob already exists, so this is a no-op
        System.out.println("After putIfAbsent(Bob): " + ages.get("Bob"));

        ages.remove("Bob");
        System.out.println("After removing Bob: " + ages);

        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        ages.forEach((name, age) -> System.out.println(name + " is " + age + " years old"));
    }
}

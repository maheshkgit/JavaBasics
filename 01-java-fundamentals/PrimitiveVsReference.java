/*
 * Primitive vs Reference types
 * -----------------------------
 * Primitives (8 total): byte, short, int, long, float, double, char, boolean.
 *   - Stored directly (by value), fixed size, live on the stack when local.
 *   - Have default values, are never null.
 *
 * Reference types: classes, interfaces, arrays, enums (e.g., String, int[], custom objects).
 *   - A variable holds a REFERENCE (pointer) to an object on the heap, not the object itself.
 *   - Can be null.
 */
public class PrimitiveVsReference {
    public static void main(String[] args) {
        // Primitives - value is stored directly in the variable
        int a = 10;
        int b = a;   // b gets a COPY of a's value
        b = 20;
        System.out.println("a=" + a + " b=" + b + "  (a is unaffected by changing b)");

        // Reference types - variable holds an address to a heap object
        int[] arr1 = {1, 2, 3};
        int[] arr2 = arr1;   // arr2 points to the SAME array object as arr1
        arr2[0] = 99;
        System.out.println("arr1[0]=" + arr1[0] + " (changed via arr2 because they reference the same object)");

        StringBuilder sb1 = new StringBuilder("Hello");
        StringBuilder sb2 = sb1;
        sb2.append(" World");
        System.out.println("sb1 = " + sb1 + "  (mutated through sb2, same object)");

        // Default values
        boolean flag; // not usable until assigned if local, but fields default to false
        Object obj = null; // reference types can be null; primitives cannot
        System.out.println("A reference variable can be null: " + obj);
    }
}

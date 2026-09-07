/*
 * Pass-by-value in Java
 * -----------------------
 * Java is ALWAYS pass-by-value. For primitives, the VALUE is copied.
 * For objects, the VALUE OF THE REFERENCE (the address) is copied - so both the
 * original and the parameter point to the same object, allowing you to mutate
 * the object's contents, but reassigning the parameter does NOT affect the caller's variable.
 */
public class PassByValue {

    static void modifyPrimitive(int x) {
        x = 999; // only changes the local copy
    }

    static void modifyArrayContents(int[] arr) {
        arr[0] = 999; // mutates the shared object - visible to caller
    }

    static void reassignArrayReference(int[] arr) {
        arr = new int[]{7, 8, 9}; // only rebinds the local variable, caller's reference is untouched
    }

    public static void main(String[] args) {
        int num = 5;
        modifyPrimitive(num);
        System.out.println("num after modifyPrimitive: " + num); // still 5

        int[] arr = {1, 2, 3};
        modifyArrayContents(arr);
        System.out.println("arr[0] after modifyArrayContents: " + arr[0]); // 999, object was mutated

        reassignArrayReference(arr);
        System.out.println("arr[0] after reassignArrayReference: " + arr[0]); // still 999, caller's reference unchanged
    }
}

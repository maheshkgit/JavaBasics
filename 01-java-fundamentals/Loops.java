/*
 * Loops: for, while, do-while, for-each, break/continue
 */
public class Loops {
    public static void main(String[] args) {
        // for loop
        System.out.println("for loop:");
        for (int i = 0; i < 5; i++) {
            if (i == 3) continue; // skip 3
            System.out.print(i + " ");
        }
        System.out.println();

        // while loop
        System.out.println("while loop:");
        int i = 0;
        while (i < 5) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println();

        // do-while loop - guaranteed to run at least once
        System.out.println("do-while loop:");
        int j = 0;
        do {
            System.out.print(j + " ");
            j++;
        } while (j < 5);
        System.out.println();

        // for-each (enhanced for) loop - iterating a collection/array
        System.out.println("for-each loop:");
        int[] numbers = {10, 20, 30, 40};
        for (int n : numbers) {
            if (n == 30) break; // stop entirely once we hit 30
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

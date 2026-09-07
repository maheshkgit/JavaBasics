/*
 * Immutable objects: once created, their state cannot change.
 * Recipe: final class, private final fields, no setters, initialize everything
 * via constructor, defensively copy mutable fields (e.g., arrays, lists, dates).
 */
public final class ImmutableObjects {

    static final class ImmutablePoint {
        private final int x;
        private final int y;

        ImmutablePoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() { return x; }
        int getY() { return y; }

        // "Mutating" methods return a NEW object instead of modifying this one
        ImmutablePoint translate(int dx, int dy) {
            return new ImmutablePoint(x + dx, y + dy);
        }

        @Override
        public String toString() { return "(" + x + ", " + y + ")"; }
    }

    public static void main(String[] args) {
        ImmutablePoint p1 = new ImmutablePoint(1, 2);
        ImmutablePoint p2 = p1.translate(3, 4); // p1 is untouched, p2 is a new object

        System.out.println("p1 = " + p1); // (1, 2)
        System.out.println("p2 = " + p2); // (4, 6)

        // Java's String is the classic built-in immutable example:
        String s1 = "hello";
        String s2 = s1.concat(" world"); // creates a NEW String; s1 is unchanged
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }
}

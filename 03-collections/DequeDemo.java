/*
 * Deque (Double-Ended Queue): supports insertion/removal at BOTH ends.
 * Can act as a Queue (FIFO) or a Stack (LIFO). Preferred over legacy Stack class.
 * Common implementation: ArrayDeque (usually faster than LinkedList/Stack).
 */
import java.util.Deque;
import java.util.ArrayDeque;

public class DequeDemo {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(0);
        System.out.println("Deque: " + deque); // [0, 1, 2]

        System.out.println("Peek first: " + deque.peekFirst());
        System.out.println("Peek last: " + deque.peekLast());

        // Using as a Stack (LIFO) - push/pop operate on the head
        Deque<String> stack = new ArrayDeque<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("Stack pop order: " + stack.pop() + ", " + stack.pop() + ", " + stack.pop());

        // Using as a Queue (FIFO) - offer/poll
        Deque<String> queue = new ArrayDeque<>();
        queue.offer("X");
        queue.offer("Y");
        queue.offer("Z");
        System.out.println("Queue poll order: " + queue.poll() + ", " + queue.poll() + ", " + queue.poll());
    }
}

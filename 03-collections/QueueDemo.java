/*
 * Queue interface: a collection designed for holding elements prior to processing,
 * typically FIFO (First-In-First-Out). Common implementations: LinkedList, ArrayDeque, PriorityQueue.
 */
import java.util.Queue;
import java.util.LinkedList;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> line = new LinkedList<>();
        line.offer("Customer1"); // preferred over add() - returns false instead of throwing on failure
        line.offer("Customer2");
        line.offer("Customer3");

        System.out.println("Queue: " + line);
        System.out.println("Peek (front, no removal): " + line.peek());

        System.out.println("Poll (removes front): " + line.poll());
        System.out.println("Queue after poll: " + line);

        while (!line.isEmpty()) {
            System.out.println("Serving: " + line.poll());
        }
        System.out.println("Poll on empty queue returns: " + line.poll()); // null, doesn't throw
    }
}

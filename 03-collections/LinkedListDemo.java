/*
 * LinkedList: doubly-linked list implementation of List and Deque.
 *  - Fast insert/remove at the ends and once you have a reference to a node (O(1)).
 *  - Slow random access by index (O(n), must traverse from an end).
 *  - Also implements Deque, so it can be used as a stack or queue.
 */
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("B");
        list.addFirst("A");   // O(1) - add to front
        list.addLast("C");    // O(1) - add to end
        System.out.println("List: " + list);

        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());

        list.removeFirst();
        System.out.println("After removeFirst: " + list);

        // Using LinkedList as a Stack (LIFO)
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack pop order: " + stack.pop() + ", " + stack.pop() + ", " + stack.pop());

        // Using LinkedList as a Queue (FIFO)
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println("Queue poll order: " + queue.poll() + ", " + queue.poll() + ", " + queue.poll());
    }
}

/*
 * PriorityQueue: a queue where elements are ordered by PRIORITY rather than
 * insertion order - the head is always the smallest element (natural ordering)
 * or per a supplied Comparator (e.g., a min-heap or max-heap). Backed by a binary heap.
 */
import java.util.PriorityQueue;
import java.util.Comparator;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        // Min-heap (default) - smallest element polled first
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(50);
        minHeap.offer(10);
        minHeap.offer(30);
        minHeap.offer(20);

        System.out.print("Polling min-heap in priority order: ");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " "); // 10 20 30 50
        }
        System.out.println();

        // Max-heap using a custom Comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.addAll(java.util.List.of(50, 10, 30, 20));

        System.out.print("Polling max-heap in priority order: ");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " "); // 50 30 20 10
        }
        System.out.println();

        // Real-world use: task scheduling by priority (lower number = higher priority)
        record Task(String name, int priority) {}
        PriorityQueue<Task> tasks = new PriorityQueue<>(Comparator.comparingInt(Task::priority));
        tasks.offer(new Task("Low priority job", 5));
        tasks.offer(new Task("Critical fix", 1));
        tasks.offer(new Task("Normal task", 3));

        while (!tasks.isEmpty()) {
            System.out.println("Next up: " + tasks.poll());
        }
    }
}

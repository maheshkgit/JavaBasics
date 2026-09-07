/*
 * ConcurrentHashMap: a thread-safe Map designed for high-concurrency access,
 * without locking the entire map (uses fine-grained/segmented locking internally).
 * Does NOT allow null keys or null values (unlike HashMap).
 */
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, Integer> counters = new ConcurrentHashMap<>();
        counters.put("hits", 0);

        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                counters.merge("hits", 1, Integer::sum); // atomic update, safe across threads
            }
        };

        Thread t1 = new Thread(incrementTask);
        Thread t2 = new Thread(incrementTask);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        // With a plain HashMap, concurrent updates from multiple threads could corrupt
        // internal state or produce a wrong count. ConcurrentHashMap guarantees correctness.
        System.out.println("Final hits (expected 2000): " + counters.get("hits"));
    }
}

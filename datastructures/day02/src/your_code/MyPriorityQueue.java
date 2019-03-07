package your_code;
import java.util.ArrayList;

/**
 * An implementation of a priority Queue
 */
public class MyPriorityQueue {

    private ArrayList<Integer> ll;


    public MyPriorityQueue() {
        ll = new ArrayList<>();
    }

    public void enqueue(int item) {
        // TODO
        if (ll.isEmpty()) {
            ll.add(item);
            return;
        }
        for (int i = 0; i < ll.size(); i++) {
            if (ll.get(i) >= item) {
                ll.add(i, item);
                return;
            }

        }
        ll.add(item);

    }

    /**
     * Return and remove the largest item on the queue.
     */
    public int dequeueMax() {
        // TODO
//
        return ll.remove(ll.size() -1);
    }

}
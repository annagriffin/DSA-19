package your_code;
import ADTs.StackADT;

import java.util.LinkedList;

/**
 * An implementation of the Stack interface.
 */
public class MyStack implements StackADT<Integer> {

    private LinkedList<Integer> ll;
    private LinkedList<Integer> other;


    public MyStack() {
        ll = new LinkedList<>();
        other = new LinkedList<>();
    }

    @Override
    public void push(Integer e) {

        ll.addFirst(e);
        if (other.isEmpty()) {
            other.addFirst(e);
        } else if (e >= other.getFirst()) {
            other.addFirst(e);
        }

    }

    @Override
    public Integer pop() {


        if (ll.getFirst() == other.getFirst()) {
            other.removeFirst();
        }
        Integer pop = ll.removeFirst();
        return pop;
    }

    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public Integer peek() {
        return ll.getFirst();
    }

    public Integer maxElement() {
        // TODO
        if (other.isEmpty()) {
            return null;
        }
        return other.getFirst();
    }
}

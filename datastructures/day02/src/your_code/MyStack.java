package your_code;
import ADTs.StackADT;

import java.util.LinkedList;

/**
 * An implementation of the Stack interface.
 */
public class MyStack implements StackADT<Integer> {

    private LinkedList<Integer> ll;

    public MyStack() {
        ll = new LinkedList<>();
    }

    LinkedList stackDude = new LinkedList();
    LinkedList trackStack = new LinkedList();

    @Override
    public void push(Integer e) {
        ll.addFirst(e);
        if (trackStack.peek() == null) {
            trackStack.push(e);
        }
        else if (e > (int)trackStack.peek()) {
            trackStack.addFirst(e);
        }
    }

    @Override
    public Integer pop() {
        Integer pop = ll.removeFirst();
        if (pop == trackStack.peek()) {
            trackStack.removeFirst();
        }
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
        return (int)trackStack.peek();
    }
}

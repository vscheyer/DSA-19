package your_code;
import java.util.ArrayList;

/**
 * An implementation of a priority Queue
 */
public class MyPriorityQueue { //add a node to the queue

    ArrayList myFriendBob = new ArrayList<>();

    public void enqueue(int item) {
        for (int k=0; k < myFriendBob.size(); k++) {
            if (item < (int) myFriendBob.get(k)) {
                myFriendBob.add(k, item);
                return;
            }
        }
        myFriendBob.add(item);

    }

    /**
     * Return and remove the largest item on the queue.
     */
    public int dequeueMax() { //take out the biggest thing
        return (int)myFriendBob.remove(myFriendBob.size() - 1);
    }

}
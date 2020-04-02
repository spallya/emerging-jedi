package queues;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueueByRecursion<E> {

    private static <E> Queue<E> reverseQueue(Queue<E> q) {
        if (q.isEmpty()) {
            return q;
        } else {
            E current = q.peek();
            q.remove();
            q = reverseQueue(q);
            q.add(current);
        }
        return q;
    }

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();
        queue.add("p");
        queue.add("r");
        queue.add("i");
        queue.add("y");
        queue.add("a");
        queue.add("n");
        queue.add("k");
        queue.add("a");

        System.out.println("Original Queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);
    }


}
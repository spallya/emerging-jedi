package linkedList;

public class DetectLoop {

    private static boolean isLoopPresent(JediLinkedList list) {
        Node slow = list.getHead();
        Node fast = list.getHead();
        while (null != slow && null != fast && null != fast.getNext()) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JediLinkedList<Integer> list = new JediLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.getHead().getNext().getNext().getNext().getNext().getNext().setNext(list.getHead());
        System.out.println("Loop is present: " + isLoopPresent(list));
    }


}

package linkedList;

public class ListUtils {

    /*
     * Leet Code:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
     * Memory Usage: 38.7 MB, less than 19.53% of Java online submissions for Merge Two Sorted Lists.
     *
     * */
    public static Node mergeTwoLists(Node<Integer> list1, Node<Integer> list2) {
        Node<Integer> fakeHead = new Node(0);
        Node<Integer> temp = fakeHead;

        Node<Integer> pointer1 = list1;
        Node<Integer> pointer2 = list2;
        while (pointer1 != null && pointer2 != null) {
            if (pointer1.getData() < pointer2.getData()) {
                temp.setNext(pointer1);
                pointer1 = pointer1.getNext();
            } else {
                temp.setNext(pointer2);
                pointer2 = pointer2.getNext();
            }
            temp = temp.getNext();
        }

        if (pointer1 != null) {
            temp.setNext(pointer1);
        }

        if (pointer2 != null) {
            temp.setNext(pointer2);
        }

        return fakeHead.getNext();
    }
}

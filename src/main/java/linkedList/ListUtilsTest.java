package linkedList;

import linkedList.doubly.DoublyNode;
import linkedList.doubly.JediDoublyLinkedList;
import linkedList.singly.JediLinkedList;
import linkedList.singly.Node;

public class ListUtilsTest {

    public static void main(String[] args) {
        mergeTwoListsTest();
        System.out.println();
        detectLoopTest();
        System.out.println();
        reverseDoublyListTest();
    }

    private static void reverseDoublyListTest() {
        JediDoublyLinkedList list = new JediDoublyLinkedList();
        list.insertAtStart(110);
        list.insertAtStart(221);
        list.insertAtStart(13);
        list.insertAtStart(44);
        list.insertAtStart(575);
        System.out.println("List: \t\t\t\t\t");
        list.print();
        DoublyNode node = ListUtils.reverseDoublyList(list.getHead());
        System.out.print("Reversed List: \t\t\t");
        while (node != null) {
            System.out.print("[" + node.getData() + "] ");
            node = node.getLinkNext();
        }
    }

    /*
    * Program Output:
    * Loop is present: true
    *
    * */
    private static void detectLoopTest() {
        JediLinkedList<Integer> list = new JediLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.getHead().getNext().getNext().getNext().getNext().getNext().setNext(list.getHead());
        System.out.println("Loop is present: " + ListUtils.isLoopPresent(list));
    }

    /*
    * Program Output:
    * List1: 					[1][3][5][7][9]
    * List2: 					[2][4][6][8][10]
    * Merged List: 			[1] [2] [3] [4] [5] [6] [7] [8] [9] [10]
    *
    * */
    private static void mergeTwoListsTest() {
        JediLinkedList<Integer> list1 = new JediLinkedList<>();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(7);
        list1.add(9);
        JediLinkedList<Integer> list2 = new JediLinkedList<>();
        list2.add(2);
        list2.add(4);
        list2.add(6);
        list2.add(8);
        list2.add(10);
        System.out.println("List1: \t\t\t\t\t" + list1);
        System.out.println("List2: \t\t\t\t\t" + list2);
        Node node = ListUtils.mergeTwoLists(list1.getHead(), list2.getHead());
        System.out.print("Merged List: \t\t\t");
        while (node != null) {
            System.out.print("[" + node.getData() + "] ");
            node = node.getNext();
        }
    }
}

package linkedList.doubly;

import linkedList.singly.JediLinkedList;

public class JediDoublyLinkedListTest {
    /*
    *
    * Program Output:
    * List:
    *
    * Doubly Linked List = 575 <-> 44 <-> 13 <-> 221 <-> 110
    * List:
    *
    * Doubly Linked List = 575 <-> 44 <-> 13 <-> 221 <-> 110 <-> 900
    * List:
    *
    * Doubly Linked List = 575 <-> 13 <-> 221 <-> 110 <-> 900
    *
    * */
    public static void main(String[] args) {
        JediDoublyLinkedList list = new JediDoublyLinkedList();
        list.insertAtStart(110);
        list.insertAtStart(221);
        list.insertAtStart(13);
        list.insertAtStart(44);
        list.insertAtStart(575);
        System.out.println("List: \t\t\t\t\t");
        list.print();
        list.insertAtEnd(900);
        System.out.println("List: \t\t\t\t\t");
        list.print();
        list.deleteAtPos(2);
        System.out.println("List: \t\t\t\t\t");
        list.print();
    }
}

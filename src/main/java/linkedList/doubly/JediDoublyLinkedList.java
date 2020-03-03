package linkedList.doubly;

public class JediDoublyLinkedList {

    protected DoublyNode head;
    protected DoublyNode tail;
    public int size;

    public JediDoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void insertAtStart(int val) {
        DoublyNode current = new DoublyNode(val, null, null);
        if (head == null) {
            head = current;
            tail = head;
        } else {
            head.setLinkPrev(current);
            current.setLinkNext(head);
            head = current;
        }
        size++;
    }

    public void insertAtEnd(int val) {
        DoublyNode current = new DoublyNode(val, null, null);
        if (head == null) {
            head = current;
            tail = head;
        } else {
            current.setLinkPrev(tail);
            tail.setLinkNext(current);
            tail = current;
        }
        size++;
    }

    public void insertAtPos(int val, int pos) {
        DoublyNode current = new DoublyNode(val, null, null);
        if (pos == 1) {
            insertAtStart(val);
            return;
        }
        DoublyNode ptr = head;
        for (int i = 2; i <= size; i++) {
            if (i == pos) {
                DoublyNode tmp = ptr.getLinkNext();
                ptr.setLinkNext(current);
                current.setLinkPrev(ptr);
                current.setLinkNext(tmp);
                tmp.setLinkPrev(current);
            }
            ptr = ptr.getLinkNext();
        }
        size++;
    }

    public void deleteAtPos(int pos) {
        if (pos == 1) {
            if (size == 1) {
                head = null;
                tail = null;
                size = 0;
                return;
            }
            head = head.getLinkNext();
            head.setLinkPrev(null);
            size--;
            return;
        }
        if (pos == size) {
            tail = tail.getLinkPrev();
            tail.setLinkNext(null);
            size--;
        }
        DoublyNode ptr = head.getLinkNext();
        for (int i = 2; i <= size; i++) {
            if (i == pos) {
                DoublyNode p = ptr.getLinkPrev();
                DoublyNode n = ptr.getLinkNext();

                p.setLinkNext(n);
                n.setLinkPrev(p);
                size--;
                return;
            }
            ptr = ptr.getLinkNext();
        }
    }

    public void print() {
        System.out.print("\nDoubly Linked List = ");
        if (size == 0) {
            System.out.print("empty\n");
            return;
        }
        if (head.getLinkNext() == null) {
            System.out.println(head.getData());
            return;
        }
        DoublyNode current = head;
        System.out.print(head.getData() + " <-> ");
        current = head.getLinkNext();
        while (current.getLinkNext() != null) {
            System.out.print(current.getData() + " <-> ");
            current = current.getLinkNext();
        }
        System.out.print(current.getData() + "\n");
    }

    public DoublyNode getHead() {
        return head;
    }

    public DoublyNode getTail() {
        return tail;
    }
}
package linkedList.doubly;

public class JediDoublyLinkedList {
    protected Node start;
    protected Node end;
    public int size;

    public JediDoublyLinkedList() {
        start = null;
        end = null;
        size = 0;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public int getSize() {
        return size;
    }

    public void insertAtStart(int val) {
        Node current = new Node(val, null, null);
        if (start == null) {
            start = current;
            end = start;
        } else {
            start.setLinkPrev(current);
            current.setLinkNext(start);
            start = current;
        }
        size++;
    }

    public void insertAtEnd(int val) {
        Node current = new Node(val, null, null);
        if (start == null) {
            start = current;
            end = start;
        } else {
            current.setLinkPrev(end);
            end.setLinkNext(current);
            end = current;
        }
        size++;
    }

    public void insertAtPos(int val, int pos) {
        Node current = new Node(val, null, null);
        if (pos == 1) {
            insertAtStart(val);
            return;
        }
        Node ptr = start;
        for (int i = 2; i <= size; i++) {
            if (i == pos) {
                Node tmp = ptr.getLinkNext();
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
                start = null;
                end = null;
                size = 0;
                return;
            }
            start = start.getLinkNext();
            start.setLinkPrev(null);
            size--;
            return;
        }
        if (pos == size) {
            end = end.getLinkPrev();
            end.setLinkNext(null);
            size--;
        }
        Node ptr = start.getLinkNext();
        for (int i = 2; i <= size; i++) {
            if (i == pos) {
                Node p = ptr.getLinkPrev();
                Node n = ptr.getLinkNext();

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
        if (start.getLinkNext() == null) {
            System.out.println(start.getData());
            return;
        }
        Node current = start;
        System.out.print(start.getData() + " <-> ");
        current = start.getLinkNext();
        while (current.getLinkNext() != null) {
            System.out.print(current.getData() + " <-> ");
            current = current.getLinkNext();
        }
        System.out.print(current.getData() + "\n");
    }
}
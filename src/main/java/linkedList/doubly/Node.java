package linkedList.doubly;

public class Node {

    protected int data;
    protected Node next, previous;

    public Node() {
        next = null;
        previous = null;
        data = 0;
    }

    public Node(int data, Node next, Node previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public void setLinkNext(Node n) {
        next = n;
    }

    public void setLinkPrev(Node p) {
        previous = p;
    }

    public Node getLinkNext() {
        return next;
    }

    public Node getLinkPrev() {
        return previous;
    }

    public void setData(int d) {
        data = d;
    }

    public int getData() {
        return data;
    }
}
package linkedList.doubly;

public class DoublyNode {

    protected int data;
    protected DoublyNode next, previous;

    public DoublyNode() {
        next = null;
        previous = null;
        data = 0;
    }

    public DoublyNode(int data, DoublyNode next, DoublyNode previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public void setLinkNext(DoublyNode n) {
        next = n;
    }

    public void setLinkPrev(DoublyNode p) {
        previous = p;
    }

    public DoublyNode getLinkNext() {
        return next;
    }

    public DoublyNode getLinkPrev() {
        return previous;
    }

    public void setData(int d) {
        data = d;
    }

    public int getData() {
        return data;
    }
}
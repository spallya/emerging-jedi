package linkedList;

import java.util.List;

public class JediLinkedList<T> {

    private Node head;

    private static int numberOfElements;

    public JediLinkedList() {
    }

    public void add(T data) {
        if (null == head) {
            head = new Node(data);
        } else {
            Node temp = new Node(data);
            Node current = head;
            while (null != current.getNext()) {
                current = current.getNext();
            }
            current.setNext(temp);
        }
        incrementNumberOfElements();
    }

    public void add(T data, int index) {
        Node temp = new Node(data);
        Node current = head;
        if (null != current) {
            for (int i = 0; i < index && current.getNext() != null; i++) {
                current = current.getNext();
            }
        }
        temp.setNext(current.getNext());
        current.setNext(temp);
        incrementNumberOfElements();
    }

    public T get(int index) {
        if (index < 0)
            return null;
        Node current = null;
        if (null != head) {
            current = head;
            for (int i = 0; i < index; i++) {
                if (null == current.getNext()) {
                    return null;
                }
                current = current.getNext();
            }
        }
        return current != null ? (T) current.getData() : null;
    }

    public boolean remove(int index) {
        if (index < 1 || index > size()) {
            return false;
        }
        Node current = null;
        if (null != head) {
            current = head;
            for (int i = 0; i < index; i++) {
                if (null == current.getNext()) {
                    return false;
                }
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            decrementNumberOfElements();
            return true;
        }
        return false;
    }

    public int size() {
        return getNumberOfElements();
    }

    private void incrementNumberOfElements() {
        numberOfElements++;
    }

    private void decrementNumberOfElements() {
        numberOfElements--;
    }

    private int getNumberOfElements() {
        return numberOfElements;
    }

    private class Node<T> {

        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

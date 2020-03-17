package stacks;

import java.util.Arrays;

public class StackUsingArray<T> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public StackUsingArray() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void push(T element) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = element;
    }

    public T pop() {
        T element = (T) elements[--size];
        elements[size] = null;
        return element;
    }

    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = size - 1; i >= 0; i--) {
            sb.append(elements[i]);
            if (i != 0) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /*
    * Program Output:
    *
    * Is Stack Empty: true
    * Current Stack: [40, 30, 20, 10]
    * Is Stack Empty: false
    * Element Popped: 40
    * Element Popped: 30
    * Element Popped: 20
    * Current Stack: [10]
    * Is Stack Empty: false
    * Element Popped: 10
    * Current Stack: []
    * Is Stack Empty: true
    *
    * */
    public static void main(String[] args) {
        StackUsingArray<Integer> stack = new StackUsingArray<>();
        System.out.println("Is Stack Empty: " + stack.isEmpty());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println("Current Stack: " + stack);
        System.out.println("Is Stack Empty: " + stack.isEmpty());
        System.out.println("Element Popped: " + stack.pop());
        System.out.println("Element Popped: " + stack.pop());
        System.out.println("Element Popped: " + stack.pop());
        System.out.println("Current Stack: " + stack);
        System.out.println("Is Stack Empty: " + stack.isEmpty());
        System.out.println("Element Popped: " + stack.pop());
        System.out.println("Current Stack: " + stack);
        System.out.println("Is Stack Empty: " + stack.isEmpty());
    }
}
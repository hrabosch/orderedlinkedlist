package org.example;

import lombok.extern.slf4j.Slf4j;

/**
 * Basic implementation within Abstract Class of Ordered Linked List.
 * <p>
 * Default behaviour is ASC order. Possible improvement is ASC/DESC flag.
 * Please read carefully implementation of removing/adding of elements, where @{@link Object#equals(Object)} is used
 * for data comparison ({@link #remove(Comparable)} or {@link #get(int)}) but @{@link Comparable#compareTo(Object)} for
 * node insertion and order decision.
 *
 * @param <T> type available to use as a data - see @{@link Node} as a representation.
 */
@Slf4j
public abstract class OrderedLinkedList<T extends Comparable> {
    private Node<T> head = null;

    public abstract void add(T data);

    void add(Node<T> node) {
        if (head == null) {
            this.head = node;
        } else {
            Node<T> current = head;
            Node<T> previous = null;
            boolean stopFlag = false;

            while (current != null && !stopFlag) {
                // ASC Order - can be checked by boolean flag if ASC or DESC in Factory
                if (current.getData().compareTo(node.getData()) > 0) {
                    stopFlag = true;
                } else {
                    previous = current;
                    current = current.getNext();
                }
            }

            node.setNext(current);
            if (previous == null) {
                head = node;
            } else {
                previous.setNext(node);
            }
        }
    }

    public abstract boolean remove(T data);
    protected boolean remove(Node<T> node) {
        Node<T> current = head;
        Node<T> previous = null;
        while (current != null) {
            if (current.getData().equals((node.getData()))) {
                if (previous != null) {
                    previous.setNext(current.getNext());
                }
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T get(int index) throws RuntimeException {
        int size = getSize();
        if (head == null) {
            throw new NullPointerException("List is empty.");
        } else if (size < index) {
            throw new ArrayIndexOutOfBoundsException("Not existing index.");
        } else {
            int counter = 0;
            Node<T> node = head;
            do {
                if (counter == index) {
                    return node.getData();
                }
                counter += 1;
                node = node.getNext();
            } while (counter < size);
        }
        log.error("Unexpected error during getting data on index: {}.", index);
        throw new RuntimeException("Unexpected error during getting data.");
    }

    public int getSize() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count += 1;
            current = current.getNext();
        }
        return count;
    }

    public int getIndex(T data) {
        Node<T> current = head;
        int currentIndex = 0;
        while (current != null) {
            if (current.getData().equals(data)) {
                return currentIndex;
            }
            currentIndex += 1;
            current = current.getNext();
        }
        return -1;
    }
}

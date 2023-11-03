package org.example;

public class StringOrderedLinkedList extends OrderedLinkedList<String> {

    @Override
    public void add(String data) {
        super.add(new Node<>(data, null));
    }

    @Override
    public boolean remove(String data) {
        return super.remove(new Node<>(data, null));
    }
}

package org.example;

public class IntegerOrderedLinkedList extends OrderedLinkedList<Integer> {
    @Override
    public void add(Integer data) {
        super.add(new Node<>(data, null));
    }

    @Override
    public boolean remove(Integer data) {
        return super.remove(new Node<>(data, null));
    }
}

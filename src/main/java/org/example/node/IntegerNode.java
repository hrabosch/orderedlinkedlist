package org.example.node;

/**
 * IOnteger version of @{@link Node} used for @{@link org.example.list.IntegerOrderedLinkedList} implementation.
 */
public class IntegerNode extends Node<Integer> {

    public IntegerNode(Integer data) {
        super(data);
    }

    @Override
    public int compareTo(Integer value) {
            return value.compareTo(this.getData());
    }

}

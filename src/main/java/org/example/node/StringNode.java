package org.example.node;

/**
 * String version of @{@link Node} used for @{@link org.example.list.StringOrderedLinkedList} impelementation.
 */
public class StringNode extends Node<String> {

    public StringNode(String data) {
        super(data);
    }
    @Override
    public int compareTo(String value) {
            return value.compareToIgnoreCase(this.getData());
    }
}

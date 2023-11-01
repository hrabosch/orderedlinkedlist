package org.example.node;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Abstraction for basic unit used as an element in @{@link org.example.list.OrderedLinkedList}
 *
 * @param <T> target type
 */
@RequiredArgsConstructor
@Getter
public abstract class Node<T> implements Comparable<T> {

    private final T data;
    @Setter
    private Node<T> next;
    boolean hasNext() {
        return next != null;
    }
}

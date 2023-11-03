package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Abstraction for basic unit used as an element in @{@link org.example.OrderedLinkedList}
 *
 * @param <T> target type
 */
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
class Node<T extends Comparable>{

    private final T data;
    @Setter
    private Node<T> next;

}

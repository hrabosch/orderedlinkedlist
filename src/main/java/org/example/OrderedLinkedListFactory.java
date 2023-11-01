package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.list.IntegerOrderedLinkedList;
import org.example.list.OrderedLinkedList;
import org.example.list.StringOrderedLinkedList;

/**
 * Factory class with method providing only known types of @{@link OrderedLinkedList}.
 * Available types:
 * <ul>
 *     <li>String</li>
 *     <li>Integer</li>
 * </ul>
 *
 * Note that by default, order is ASC. Extending TYPES to use flag for ASC/DESC can be added.
 */
@Slf4j
public class OrderedLinkedListFactory {
    /**
     * Factory method for known implementations of @{@link OrderedLinkedList}
     * @param type parameter to select desired implementation
     * @return implementation of @{@link OrderedLinkedList} for given @{@link OrderedLinkedListType}
     */
    public static OrderedLinkedList createOrderedLinkedList(OrderedLinkedListType type) {
        return switch (type) {
            case OrderedLinkedListType.STRING -> new StringOrderedLinkedList();
            case OrderedLinkedListType.INTEGER -> new IntegerOrderedLinkedList();
        };
    }

    /**
     * Available types of @{@link OrderedLinkedList} implementations
     */
    public enum OrderedLinkedListType {
        STRING,
        INTEGER
    }
}

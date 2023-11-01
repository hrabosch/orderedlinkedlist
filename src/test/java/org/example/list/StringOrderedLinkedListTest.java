package org.example.list;

import org.example.OrderedLinkedListFactory;
import org.example.node.StringNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringOrderedLinkedListTest {

    public final List<String> testingStrings = Arrays.asList("Lorem", "Ipsum", "dolor", "sit", "amet");

    @Test
    @DisplayName("Test String OrderedLinkedList on adding elements, getting size, index and removing them.")
    void testRemovalBasedOnDataAndIndexLookup() {
        // GIVEN
        OrderedLinkedList<String> list = OrderedLinkedListFactory.createOrderedLinkedList(OrderedLinkedListFactory.OrderedLinkedListType.STRING);
        String stringToRemove = testingStrings.get(0);

        // WHEN
        testingStrings.forEach(string -> list.add(new StringNode(string)));
        int index = list.getIndex(stringToRemove);

        //THEN
        assertTrue(index >= 0, "Index has to be found");
        assertEquals(testingStrings.size(), list.getSize(), "Tested list does not contains correct number of elements.");

        // WHEN
        list.remove(stringToRemove);
        index = list.getIndex(stringToRemove);

        // THEN
        assertEquals(-1, index, "Index for non existing string has to be -1.");
        assertEquals(testingStrings.size() - 1, list.getSize(), "Tested list does not contains correct number of elements.");
        assertTrue(list.get(0).equalsIgnoreCase(testingStrings.getLast()), "First node is not in valid order.");
    }

}
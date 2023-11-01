package org.example.list;

import org.example.OrderedLinkedListFactory;
import org.example.node.IntegerNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegerOrderedLinkedListTest {

    public final List<Integer> testingIntegers = Arrays.asList(2,8,10,1,9,18);

    @Test
    @DisplayName("Test Integer OrderedLinkedList on adding elements, getting size, index and removing them.")
    void testRemovalBasedOnDataAndIndexLookup() {
        // GIVEN
        OrderedLinkedList<Integer> list = OrderedLinkedListFactory.createOrderedLinkedList(OrderedLinkedListFactory.OrderedLinkedListType.INTEGER);
        Integer integerToRemove = testingIntegers.get(0);

        // WHEN
        testingIntegers.forEach(number -> list.add(new IntegerNode(number)));
        int index = list.getIndex(integerToRemove);

        //THEN
        assertTrue(index >= 0, "Index has to be found");
        assertEquals(testingIntegers.size(), list.getSize() , "Tested list does not contains correct number of elements.");

        // WHEN
        list.remove(integerToRemove);
        index = list.getIndex(integerToRemove);

        // THEN
        assertEquals(-1,index, "Index for non existing string has to be -1.");
        assertTrue(list.getSize() == testingIntegers.size() - 1, "Tested list does not contains correct number of elements.");
        assertTrue(list.get(0) < list.get(1), "First node is not in valid order.");
    }

}
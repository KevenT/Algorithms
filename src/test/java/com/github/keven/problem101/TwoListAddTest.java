package com.github.keven.problem101;

import com.github.keven.linkedlist.ListNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoListAddTest {

    private TwoListAdd twoListAdd;
    @Before
    public void setUp() throws Exception {
        twoListAdd = new TwoListAdd();
    }

    @After
    public void tearDown() throws Exception {
        twoListAdd = null;
    }

    @Test
    public void addList() {
        ListNode<Integer> head1 = createList(new Integer[] { 9,2, 9 });
        ListNode<Integer> head2 = createList(new Integer[] { 9,2, 9 });
        ListNode<Integer> head = twoListAdd.addList(head1,head2);


        assertListContainsElements(new Integer[] { 1,8, 5, 8 }, head);
    }
    @Test//(expected = IllegalArgumentException.class)
    public void shouldNotAcceptNullInstancesAsParameter2() {
        ListNode<Integer> head1 = createList(new Integer[] { 9,2, 9 });
        ListNode resultNode =twoListAdd.addList(head1,null);
        assertListContainsElements(new Integer[] { 9,2,9 }, resultNode);
//        assertNull(resultNode);
    }

    private ListNode<Integer> createList(Integer[] integers) {
        ListNode<Integer> head = new ListNode<Integer>(integers[0]);
        if (integers.length > 1) {
            ListNode<Integer> prevNode = head;
            for (int i = 1; i < integers.length; i++) {
                ListNode<Integer> currentNode = new ListNode<Integer>(integers[i]);
                prevNode.setNext(currentNode);
                prevNode = currentNode;
            }
        }
        return head;
    }
    private void assertListContainsElements(Integer[] integers, ListNode<Integer> head) {
        int arrayLength = integers.length;
        ListNode<Integer> currentNode = head;

        int i = 0;
        while (i < arrayLength) {
            assertEquals(integers[i], currentNode.getData());
            currentNode = currentNode.getNext();
            i++;
        }
        assertNull(currentNode);
    }
}
/*
 * Copyright (C) 2014 Pedro Vicente Gómez Sánchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.keven.problem59;

import com.github.keven.linkedlist.ListNode;

import java.util.Stack;

/**
 * Implement an algorithm to delete a node in the middle of a singly linked list, given only access
 * to that node.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class DeleteListNode {

    /**
     * Iterative algorithm to solve this problem. We don't have access to the head of the list, and
     * the only thing we can do is to move the data from the next node to the current one, the data
     * and the pointer to the next node. This approach doesn't work with the last element in the
     * list, but there is no another valid approach to solve this algorithm without access to the
     * head of the list.
     */
    public void delete(ListNode node) {
        validateInputData(node);

        if (node.getNext() == null) {
            return;
        }
        ListNode next = node.getNext();
        node.setData(next.getData());
        node.setNext(next.getNext());
    }

    private void validateInputData(ListNode node) {
        if (node == null) {
            throw new IllegalArgumentException(
                    "You can't pass a null instance of ListNode as parameter.");
        }
    }


    //  删除单链表中的指定节点
    public void deleteNode(ListNode head, ListNode node) {

        validateInputData(head);
        validateInputData(node);

        //删除尾节点，采用顺序查找找到尾节点的前一节点
        if (node.getNext() == null) {
            while (head.getNext() != node) {
                head = head.getNext();
            }
            head.setNext(null);
        }

        //要删除的节点是头结点
        else if (head == node) {
            head = null;
        }

        //要删除的节点是中间节点
        else {
            ListNode q = node.getNext();
            node.setData(q.getData());
            node.setNext(q.getNext());
        }
    }


    // 单链表中删除指定数值的节点方法一：利用栈
    public ListNode removeValue(ListNode<Integer> head, int num) {
        validateInputData(head);

        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null) {
            if (num != head.getData()) {
                stack.push(head);
            }
            head.setNext(head.getNext());
        }
        while (!stack.isEmpty()) {
            stack.peek().setNext(head);
            head = stack.pop();
        }

        return head;
    }

    // 单链表中删除指定数值的节点方法二：不利用栈
    public ListNode removeValue2(ListNode<Integer> head, int num) {
        validateInputData(head);

        while (head != null) {
            if (head.getData() != num) {
                break;
            }
            head = head.getNext();
        }
        ListNode<Integer> pre = head;
        ListNode<Integer> cur = head;
        while (cur != null) {
            if (cur.getData() == num) {
                pre.setNext(cur.getNext());
            } else {
                pre = cur;
            }
            cur = cur.getNext();
        }
        return head;
    }


// 删除单链表倒数第k个节点
    public ListNode removeLastKthNode (ListNode head,int k){
        if (k<0 || head == null){
            return  head;
        }
        ListNode p = head;
        for (int i =0;i<k;i++){
            if (p.getNext()!=null){
                p= p.getNext();
            }else{
                return head;
            }
        }
        ListNode q = head;
        while (p.getNext()!=null){
            p = p.getNext();
            q = q.getNext();
        }
        q.setNext(q.getNext().getNext());
        return head;
    }

}

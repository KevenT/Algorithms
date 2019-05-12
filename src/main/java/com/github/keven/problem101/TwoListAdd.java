package com.github.keven.problem101;

import com.github.keven.linkedlist.ListNode;

import java.util.Stack;

/**
 * 两个单向链表相加
 * @author keven
 */
public class TwoListAdd {

    public ListNode addList(ListNode<Integer> head1,ListNode<Integer> head2){
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        while(head1!=null){
            stack1.push(head1.getData());
            head1= head1.getNext();
        }
        while(head2!=null){
            stack2.push(head2.getData());
            head2= head2.getNext();
        }
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        int ca = 0;

        ListNode node = null;
        ListNode pnode = null;
        while(!stack1.isEmpty()||!stack2.isEmpty()){
            n1 = stack1.isEmpty() ? 0 :stack1.pop();
            n2 = stack2.isEmpty() ? 0 :stack2.pop();
            n =n1+n2+ca;
            node = new ListNode(n%10);
            node.setNext(pnode);
            pnode = node;
            ca = n/10;
        }
        if (ca==1){
            pnode = node;
            node = new ListNode(n/10);
            node.setNext(pnode);

        }

        return node;

    }

}

package com.github.keven.problem102;

import java.util.Stack;

/**
 * 设计含最小函数min()的函数，要求min、push、pop的时间复杂度为O(1)。
 * 可以使用栈实现有序队列。以后再做。
 */
public class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int node){
        stack.push(node);
        if (minStack.isEmpty() || (minStack.peek()>=node)){
            minStack.push(node);
        }
    }
    public  void pop(){
        if (stack.isEmpty()){
            return;
        }
        int node = stack.peek();
        stack.pop();
        if (minStack.peek() == node){
            minStack.pop();
        }
    }

    public int min(){
        return minStack.peek();
    }


}

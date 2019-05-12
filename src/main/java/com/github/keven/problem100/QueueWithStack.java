package com.github.keven.problem100;

import java.util.Stack;

public class QueueWithStack {

    private static Stack<Object> stack1 = new Stack<Object>();
    private static Stack<Object> stack2 = new Stack<Object>();

    public static void appendTail(Object item) {
        stack1.push(item);

    }

    public static void deleteHead() {
        if (!stack2.empty()) {
            System.out.println("pop item:" + stack2.pop());
        } else {
            if (stack1.empty()) {
                throw new RuntimeException("队列为空");
            }
            while (!stack1.empty()) {
                Object item = stack1.pop();
                stack2.push(item);
            }
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        QueueWithStack q = new QueueWithStack();
        q.appendTail(1);
        q.appendTail(2);
        q.appendTail(3);

//        System.out.println(q.deQueue());
//        System.out.println(q.deQueue());
//        System.out.println(q.deQueue());
    }

}

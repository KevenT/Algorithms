package com.github.keven.problem100;

import java.util.Stack;

public class QueueWithStack3 {

    // class of queue having two stacks
    static class Queue {
        Stack<Integer> stack1;
    }

    /* Function to push an item to stack*/
    static void push(Stack<Integer> top_ref, int new_data)
    {
        /* put in the data */
        top_ref.push(new_data);
    }

    /* Function to pop an item from stack*/
    static int pop(Stack<Integer> top_ref)
    {
        /*If stack is empty then error */
        if (top_ref == null) {
            System.out.println("Stack Underflow");
            System.exit(0);
        }
        // return element from stack
        return top_ref.pop();
    }

    /* Function to enqueue an item to queue */
    static void enQueue(Queue q, int x)
    {
        push(q.stack1, x);
    }

    /* Function to deQueue an item from queue */
    static int deQueue(Queue q)
    {

        System.out.println("====deQueue==");
        int x, res = 0;
        /* If the stacks is empty then error */
        if (q.stack1.isEmpty()) {
            System.out.println("Q is Empty");
            System.exit(0);
        }
        // Check if it is a last element of stack
        else if (q.stack1.size() == 1) {
            System.out.println("====The last one=="+q.stack1.peek());
            return pop(q.stack1);
        }
        else {

            /* pop an item from the stack1 */
            x = pop(q.stack1);
            System.out.println("====x=="+x);
            /* store the last deQueued item */
            res = deQueue(q);

            System.out.println("====res=="+res);

            System.out.println("===push=x=="+x);
            /* push everything back to stack1 */
            push(q.stack1, x);
            return res;
        }
        return 0;
    }

    /* Driver function to test above functions */
    public static void main(String[] args)
    {
        /* Create a queue with items 1 2 3*/
        Queue q = new Queue();
        q.stack1 = new Stack<Integer>();

        enQueue(q, 1);
        enQueue(q, 2);
        enQueue(q, 3);
        enQueue(q, 4);
        enQueue(q, 5);

        /* Dequeue items */
        System.out.println(deQueue(q) + " ******");
        System.out.println(deQueue(q) + " *****");
        System.out.println(deQueue(q) + " ****");
        System.out.println(deQueue(q) + " ***");
        System.out.println(deQueue(q) + " *");
    }
}
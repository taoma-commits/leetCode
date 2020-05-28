/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Queue using Stacks.
Memory Usage: 40.7 MB, less than 6.25% of Java online submissions for Implement Queue using Stacks.
@Stack
@queue
*/

//Solution 1: push O(n), pop O(1);
class MyQueue {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> helper = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stack.empty()){
            helper.push(stack.pop());
        }
        stack.push(x);
        while (!helper.empty()) {
            stack.push(helper.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.empty();
    }
}

//Solution 2: push O(1), pop amortized O(1) worst case O(n).

class MyQueue {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    private int top;

    /** Initialize your data structure here. */
    public MyQueue() {
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (s1.empty()) top = x;
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (s2.empty()) {
            while (!s1.empty()) s2.push(s1.pop());
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (s2.empty()) return this.top;
        else {
            while (!s1.empty()) s2.push(s1.pop());
        }
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}

/*
Do you know when we should use two stacks to implement a queue?
The application for this implementation is to separate read & write
of a queue in multi-processing. One of the stack is for read,
and another is for write. They only interfere each other when the
former one is full or latter is empty.
*/

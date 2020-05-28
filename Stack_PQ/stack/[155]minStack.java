/* Runtime: 5 ms, faster than 59.15% of Java online submissions for Min Stack.
 * Memory Usage: 39.7 MB, less than 38.41% of Java online submissions for Min Stack.
 */

class MinStack {
    /** initialize your data structure here. */
    private Stack<Integer> values = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public MinStack() {
    }

    public void push(int x) {
        if (values.empty() || x <= min.peek()) min.push(x);
        values.push(x);
    }

    public void pop() {
        int x = values.pop();
        if (x == min.peek()) min.pop();
    }

    public int top() {
        return values.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

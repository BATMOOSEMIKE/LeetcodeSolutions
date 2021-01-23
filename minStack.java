class MinStack {

    Node top;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        top = null;
        minStack = new Stack<Integer>();
    }

    public void push(int x) {
        Node newNode = new Node(x);
        if(top == null){
            top = newNode;
            minStack.push(x);
        }
        else {
            newNode.next = top;
            top = newNode;

            if(x < minStack.peek()){
                minStack.push(x);
            }
            else {
                minStack.push(minStack.peek());
            }
        }
    }

    public void pop() {
        Node nextNode = top.next;
        top = nextNode;
        minStack.pop();
    }

    public int top() {
        return top.data;
    }

    public int getMin() {
        return minStack.peek();
    }
}

class Node {
    int data;
    Node next;

    public Node(int n){
        data = n;
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

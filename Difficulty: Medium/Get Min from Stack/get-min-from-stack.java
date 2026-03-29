class SpecialStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    public SpecialStack() {
        // Define Stack
        st=new Stack<>();
        minSt=new Stack<>();
    }

    public void push(int x) {
        // Add an element to the top of Stack
        st.push(x);
        if(minSt.isEmpty() || minSt.peek()>=x)minSt.push(x);
    }

    public void pop() {
        // Remove the top element from the Stack
        if(st.isEmpty())return;
        if(minSt.peek()==st.peek())minSt.pop();
        st.pop();
    }

    public int peek() {
        // Returns top element of the Stack
        if (st.isEmpty()) return -1;
        return st.peek();
    }

    boolean isEmpty() {
        // Check if the stack is empty
        return st.isEmpty();
    }

    public int getMin() {
        // Finds minimum element of Stack
        if (st.isEmpty()) return -1;
        return minSt.peek();
    }
}
class MinStack {

    private class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    Stack<Pair> st = new Stack<>();

    public MinStack() {
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push(new Pair(val, val));  
        } else {
            int currentMin = Math.min(val, st.peek().second);
            st.push(new Pair(val, currentMin));
        }
    }

    public void pop() {
        st.pop();  
    }

    public int top() {
        return st.peek().first;
    }

    public int getMin() {
        return st.peek().second;
    }
}

class Solution {
    public boolean isBalanced(String s) {
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='(' || ch=='[' || ch=='{')st.push(ch);
            else{
                if(st.isEmpty())return false;
                char top=st.peek();
                if(ch==')' && top=='(')st.pop();
                else if(ch==']' && top=='[')st.pop();
                else if(ch=='}' && top=='{')st.pop();
                else return false;
            }
        }
        return st.isEmpty();
    }
}

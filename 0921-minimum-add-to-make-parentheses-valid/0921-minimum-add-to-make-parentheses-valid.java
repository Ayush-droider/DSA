class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        int ans=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                st.push('(');
            }
            else{
                if(st.isEmpty()){
                    ans++;
                }
                else if(st.peek()=='(')st.pop();
            }
        }
        return ans+st.size();
    }
}
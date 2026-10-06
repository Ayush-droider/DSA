class Solution {
    public int minSwaps(String s) {
        Stack<Character> st=new Stack<>();
        int ans=0;
        for(char ch:s.toCharArray()){
            if(ch=='[')st.push(ch);
            else{
                if(!st.isEmpty()){
                    st.pop();
                }
                else{
                    ans++;
                }
            }
        }
        return (ans+1)/2;
    }
}
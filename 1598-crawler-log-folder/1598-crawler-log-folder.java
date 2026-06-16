class Solution {
    public int minOperations(String[] logs) {
        int count=0;
        Stack<String> st=new Stack<>();
        for(String s:logs){
            if(s.equals("./"))continue;
            else if(s.equals("../")){
                if(!st.isEmpty()){
                    st.pop();
                    count--;
                }
            }
            else{
                st.push(s);
                count++;
            }
        }
        return count;
    }
}
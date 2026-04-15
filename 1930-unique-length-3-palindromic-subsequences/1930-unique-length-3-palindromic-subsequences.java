class Solution {
    public int countPalindromicSubsequence(String s) {
        // helper(0,s,new StringBuilder());
        // return st.size();
        
        int count=0;

        for(char ch='a';ch<='z';ch++){
            int left=-1,right=-1;
            for(int i=0;i<s.length();i++){
                if(ch==(s.charAt(i))){
                    if(left==-1)left=i;
                    right=i;
                }
            }
            if(left!=-1 && right!=-1 && left<right){
                    Set<Character> st=new HashSet<>();
                    for(int k=left+1;k<right;k++){
                        st.add(s.charAt(k));
                    }
                    count+=st.size();
                }
        }
        return count;
    }
    // private void helper(int idx, String s, StringBuilder sb) {
    // if (sb.length()==3) {
    //     if (isPalindrome(sb.toString())) {
    //         st.add(sb.toString());
    //     }
    //     return;
    // }
    // if(idx>=s.length())return;
    // sb.append(s.charAt(idx));
    // helper(idx+1,s,sb);
    // sb.deleteCharAt(sb.length()-1);
    // helper(idx+1,s,sb);
    // }
    // private boolean isPalindrome(String str){
    //     int i=0,j=str.length()-1;
    //     while(i<j){
    //         if(str.charAt(i)!=str.charAt(j))return false;
    //         i++;
    //         j--;
    //     }
    //     return true;
    // }
}
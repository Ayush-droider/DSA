class Solution {
    public String reverseWords(String s) {
        StringBuilder ans=new StringBuilder();
        String[] arr=s.split(" ");
        for(String str:arr){
            StringBuilder sb=new StringBuilder(str); 
            ans.append(sb.reverse()+" ");
        }
        return ans.toString().trim();
    }
}
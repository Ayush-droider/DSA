class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb=new StringBuilder();
        int[] count=new int[s.length()];

        for(char ch:s.toCharArray()){

            int idx=sb.length();

            sb.append(ch);

            if(idx>0 && sb.charAt(idx-1)==ch) {
                count[idx]=count[idx-1]+1;
            }else{
                count[idx]=1;
            }

            if(count[idx]==k){
                sb.delete(idx-k+1, idx+1);
            }
        }
        return sb.toString();
    }
}
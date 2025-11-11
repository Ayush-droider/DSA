class Solution {
    public int compress(char[] chars) {
        int i=0;
        int index=0;
        int n=chars.length;
        while(i<n){
            int count=0;
            char char_curr=chars[i];
            while(i<n && chars[i]==char_curr){
                i++;
                count++;
            }
            chars[index]=char_curr;
            index++;
            if(count>1){
            String s=String.valueOf(count);
                for(char ch:s.toCharArray()){
                    chars[index]=ch;
                    index++;
                }
            }
        }
        return index;
    }
}
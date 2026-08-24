class Solution {
    public int partitionString(String s) {
       boolean[] seen=new boolean[26];
       int count=1;
       for(char ch:s.toCharArray()){
        int index=ch-'a';
        if(seen[index]){
            count++;
            seen=new boolean[26];
        }
        seen[index]=true;
       } 
       return count;
    }
}
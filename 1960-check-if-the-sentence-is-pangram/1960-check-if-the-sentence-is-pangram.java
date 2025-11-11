class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] count=new int[26];
        for(char ch:sentence.toCharArray()){
            count[ch-'a']=1;
        }
        int p=1;
        for(int i=0;i<26;i++){
            if(count[i]!=1){
                return false;
            }
        }
        return true;
    }
}
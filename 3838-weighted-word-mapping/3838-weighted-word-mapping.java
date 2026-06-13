class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder b=new StringBuilder();
        for(String word:words){
            int sum=0;
            for(char ch:word.toCharArray()){
                sum+=weights[ch-'a'];
            }
            int mod=sum%26;
            char ch1=(char)('z'-mod);
            b.append(ch1);
        }
        return b.toString();
    }
}
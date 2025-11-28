class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n=tokens.length;
        Arrays.sort(tokens);
        int maxScore=0;
        int Score=0;
        int i=0,j=n-1;
        while(i<=j){
            if(power>=tokens[i]){
                power-=tokens[i];
                Score+=1;
                i++;
                maxScore=Math.max(Score,maxScore);
            }
            else if(Score>0){
                power+=tokens[j];
                Score-=1;
                j--;
            }
            else{
                return maxScore;
            }
        }
        return maxScore;
    }
}
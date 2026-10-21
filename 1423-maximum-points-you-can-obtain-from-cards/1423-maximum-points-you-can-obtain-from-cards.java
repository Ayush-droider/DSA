
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int total=0;
        for(int num:cardPoints){
            total+=num;
        }
        int n=cardPoints.length;
        int i=0,j=0;
        int sum=0;
        int ans=0;
        if(k==n)return total;
        while(j<cardPoints.length){
            sum+=cardPoints[j];
            while((j-i+1)>(n-k)){
                sum-=cardPoints[i];
                i++;
            }
            if((j-i+1)==n-k){
                ans=Math.max(ans,total-sum);
            }
            j++;
        }
        return ans;
    }
}

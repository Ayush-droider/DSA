class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return Maxi(n-1,nums,dp);
    }
    private int Maxi(int idx,int[] arr,int[] dp){
        if(idx==0){
            return arr[idx];
        }
        if(idx<0){
            return 0;
        }
        if(dp[idx]!=-1)return dp[idx];

        int doi=arr[idx]+Maxi(idx-2,arr,dp);
        int undo=0+Maxi(idx-1,arr,dp);
        return dp[idx]=Math.max(doi,undo);
    }
}
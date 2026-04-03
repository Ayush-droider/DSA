class Solution {
    Integer[] dp1;
    Integer[] dp2;
    public int rob(int[] nums) {
        int[] a=new int[nums.length-1];
        int[] b=new int[nums.length-1];
        if(nums.length==1)return nums[0];
        for(int i=0;i<nums.length-1;i++){
            a[i]=nums[i];
        }

        for(int j=1;j<nums.length;j++){
            b[j-1]=nums[j];
        }

        dp1=new Integer[nums.length];
        dp2=new Integer[nums.length];

        int x=helper(0,a,dp1);
        int y=helper(0,b,dp2);

        return Math.max(x,y);
    }
    private int helper(int idx,int[] nums,Integer[] dp){
        if(idx>=nums.length)return 0;

        if(idx==nums.length-1)return nums[idx];

        if(dp[idx]!=null)return dp[idx];

        int nochori=0+helper(idx+1,nums,dp);
        int chori=nums[idx]+helper(idx+2,nums,dp);

        return dp[idx]=Math.max(chori,nochori);
    }
}
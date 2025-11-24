class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n=nums.length;
        long sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        long ls=0,rs=0;
        long result=Integer.MAX_VALUE;
        int idx=-1;
        for(int i=0;i<n;i++){
            ls+=nums[i];
            rs=sum-ls;
            int n1=i+1;
            int n2=n-n1;
            long left_avg=ls/n1;
            long right_avg=(i==n-1)?0:rs/n2;
            long ans=Math.abs(left_avg-right_avg);
            if(result>ans){
                result=ans;
                idx=i;
            }
        }
        return idx;
    }
}
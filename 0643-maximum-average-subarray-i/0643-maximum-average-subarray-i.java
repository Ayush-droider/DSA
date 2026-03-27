class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans=Double.NEGATIVE_INFINITY;
        int i=0,j=0;
        int n=nums.length;
        double sum=0;

        while(j<n){
            sum+=nums[j];

            if((j-i+1)==k){
                ans=Math.max(ans,sum/k);

                sum-=nums[i];
                i++;
            }
            j++;
        }
        return ans;
    }
}
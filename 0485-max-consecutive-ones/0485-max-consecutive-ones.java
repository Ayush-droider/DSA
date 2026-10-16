class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans=0,maxi=0;
        for(int num:nums){
            if(num==1){
                ans++;
                maxi=Math.max(maxi,ans);
            }
            else ans=0;
        }
        return maxi;
    }
}
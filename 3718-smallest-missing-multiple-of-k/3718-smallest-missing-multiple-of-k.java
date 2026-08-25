class Solution {
    private int getMax(int[] nums){
        int maxi=nums[0];
        for(int i=1; i<nums.length;i++){
            maxi=Math.max(maxi,nums[i]);
        }
        return maxi;
    }
    public int missingMultiple(int[] nums,int k){
        int maxi=getMax(nums);
        for(int i=1;i<=maxi;i++){
            if(i%k==0){
                boolean found=false;
                for(int num:nums){
                    if(num==i){
                        found=true;
                        break;
                    }
                }

                if(!found){
                    return i;
                }
            }
        }
        int ans=maxi+1;
        while(ans%k!=0){
            ans++;
        }
        return ans;
    }
}
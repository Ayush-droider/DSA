class Solution {
    public int minimumDistance(int[] nums) {
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    for(int k=j+1;k<nums.length;k++){
                        if(nums[j]==nums[k]){
                            int ans=Math.abs(j-i)+Math.abs(k-j)+Math.abs(k-i);
                            mini=Math.min(ans,mini);
                        }
                    }
                }
            }
        }
        return (mini==Integer.MAX_VALUE)?-1:mini;
    }
}
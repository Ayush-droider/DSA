class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        int closest=nums[0]+nums[1]+nums[2];
        for(int k=0;k<=n-3;k++){
            int i=k+1,j=n-1;
            while(i<j){
                int sum=nums[k]+nums[i]+nums[j];
                if(Math.abs(sum-target)<Math.abs(closest-target)){
                    closest=sum;
                }
                if(sum>target)j--;
                else if(sum<target)i++;
                else{
                    return sum;
                }
            }
        }
        return closest;
    }
}
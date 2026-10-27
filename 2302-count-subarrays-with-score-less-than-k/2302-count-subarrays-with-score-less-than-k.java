
class Solution {
    public long countSubarrays(int[] nums, long k) {
        int i=0,j=0,n=nums.length;
        long sum=0,count=0;
        while(j<n){
            sum+=nums[j];
            while(sum*(j-i+1)>=k){
                sum-=nums[i];
                i++;
            }
            count+=j-i+1;
            j++;
        }
        return count;
    }
}
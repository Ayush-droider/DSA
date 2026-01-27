class Solution {
    public int majorityElement(int[] nums) {
        int cand=nums[0];
        int l=nums.length;
        int c=1;
        for(int i=1;i<l;i++)
        {
            if(c==0)
            cand=nums[i];

            if(nums[i]!=cand)
            c--;
            else
            c++;
        }
        return cand;
    }
}
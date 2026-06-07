class Solution {
    private int getleftSum(int start,int end,int[] nums){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=start;i<end;i++){
            map.putIfAbsent(nums[i],1);
        }
        return map.size();
    }
    private int getrightSum(int start,int end,int[] nums){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=start;i<end;i++){
            map.putIfAbsent(nums[i],1);
        }
        return map.size();
    }
    public int[] distinctDifferenceArray(int[] nums) {
        int[] ans=new int[nums.length];
        int leftSum=0,rightSum=0;
        for(int i=0;i<nums.length;i++){
            leftSum=getleftSum(0,i+1,nums);
            rightSum=getrightSum(i+1,nums.length,nums);
            ans[i]=(leftSum-rightSum);
        }
        return ans;
    }
}
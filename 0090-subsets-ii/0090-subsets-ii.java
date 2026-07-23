class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(0,nums,new ArrayList<>());
        return ans;
    }
    private void helper(int idx,int[] nums,List<Integer> list){
        
        ans.add(new ArrayList<>(list));
        
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1])continue;
            list.add(nums[i]);
            helper(i+1,nums,list);
            list.remove(list.size()-1);
        }
    }
}
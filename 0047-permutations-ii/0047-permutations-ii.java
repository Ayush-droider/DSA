class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    private void helper(int[] nums,List<Integer> list,boolean[] lechuka){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(lechuka[i])continue;
            if(i>0 && nums[i]==nums[i-1] && !lechuka[i-1])continue;
            lechuka[i]=true;
            list.add(nums[i]);
            helper(nums,list,lechuka);
            lechuka[i]=false;
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] lechuka=new boolean[nums.length];
        helper(nums,new ArrayList<>(),lechuka);
        return ans;
    }
}
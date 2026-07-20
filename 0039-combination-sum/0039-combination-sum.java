class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    private void helper(int idx,int[] candidates,int target,List<Integer> list){
        if(idx==candidates.length){
            if(target==0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if(candidates[idx]<=target){
            list.add(candidates[idx]);
            helper(idx,candidates,target-candidates[idx],list);
            list.remove(list.size()-1);
        }
        helper(idx+1,candidates,target,list);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(0,candidates,target,new ArrayList<>());
        return ans;
    }
}
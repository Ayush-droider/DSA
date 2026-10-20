class Solution {
    List<List<Integer>> list=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(0,candidates,target,new ArrayList<>());
        return list;
    }
    private void helper(int idx,int[] candidates,int target,List<Integer> subList){
        if(target==0){
            list.add(new ArrayList<>(subList));
            return;
        }
        if(idx==candidates.length){
            if(target==0){
                list.add(new ArrayList<>(subList));
            }
            return;
        }
        if(candidates[idx]<=target){
            subList.add(candidates[idx]);
            helper(idx,candidates,target-candidates[idx],subList);
            subList.remove(subList.size()-1);
        }
        helper(idx+1,candidates,target,subList);
    }
}
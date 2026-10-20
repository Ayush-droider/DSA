class Solution {
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list=new ArrayList<>();
        int n=candidates.length;
        Arrays.sort(candidates);
        helper(0,candidates,target,new ArrayList<>(),n,list);
        return list;
    }
    private void helper(int idx,int[] candidates,int target,List<Integer> subList,int n,List<List<Integer>> list){

        if(target==0){
            list.add(new ArrayList<>(subList));
            return;
        }

        for(int i=idx;i<n;i++){
            if(i>idx && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            subList.add(candidates[i]);
            helper(i+1,candidates,target-candidates[i],subList,n,list);
            subList.remove(subList.size()-1);
        }
    }
}
class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(0,k,n,new ArrayList<>());
        return ans;
    }
    private void helper(int idx,int k,int target,List<Integer> list){
        if(target<0)return;

        if(list.size()==k){
            if(target==0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if(idx>=9)return;
        
        list.add(idx+1);
        helper(idx+1,k,target-(idx+1),list);
        list.remove(list.size()-1);
        helper(idx+1,k,target,list);
    }
}
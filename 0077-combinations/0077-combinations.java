class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        helper(1,n,k,new ArrayList<>());
        return ans;
    }
    private void helper(int start,int n,int k,List<Integer> list){
        if(list.size()==k){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<=n;i++){
            list.add(i);
            helper(i+1,n,k,list);
            list.remove(list.size()-1);
        }
    }
}
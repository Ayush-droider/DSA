class Solution {
    List<List<Integer>> list=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(1,k,n,new ArrayList<>());
        return list;
    }
    private void helper(int idx,int size,int target,List<Integer> subList){

        if(subList.size()==size){
            if(target==0){
                list.add(new ArrayList<>(subList));
                return;
            }
        }

        for(int i=idx;i<=9;i++){
            if(i>target)break;
            subList.add(i);
            helper(i+1,size,target-i,subList);
            subList.remove(subList.size()-1);
        }
    }
}
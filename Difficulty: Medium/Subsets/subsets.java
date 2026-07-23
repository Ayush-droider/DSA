class Solution {
    ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        // code here
        helper(0,arr,new ArrayList<>());
        return ans;
    }
    private void helper(int idx,int[] arr,List<Integer> list){
        if(idx==arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[idx]);
        helper(idx+1,arr,list);
        list.remove(list.size()-1);
        helper(idx+1,arr,list);
    }
}
class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] lechuka=new boolean[nums.length];
        helper(nums,lechuka,new ArrayList<>());
        return ans;
    }
    private void helper(int[] nums,boolean[] lechuka,List<Integer> list){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(lechuka[i])continue;
            lechuka[i]=true;
            list.add(nums[i]);
            helper(nums,lechuka,list);
            lechuka[i]=false;
            list.remove(list.size()-1);
        }
    }
}
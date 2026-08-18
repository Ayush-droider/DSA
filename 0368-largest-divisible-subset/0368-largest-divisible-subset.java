class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Arrays.sort(nums);
        // List<Integer> result=new ArrayList<>();
        // List<Integer> temp=new ArrayList<>();
        // helper(nums,0,-1,result,temp);
        // return result;

        Arrays.sort(nums);
        int[] dp=new int[1001];
        Arrays.fill(dp,1);
        int maxLen=1;
        int last_chosen_idx=0;
        int[] prev_idx=new int[1001];
        Arrays.fill(prev_idx,-1);
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    if(dp[i]<dp[j]+1){
                        dp[i]=dp[j]+1;
                        prev_idx[i]=j;
                    }
                    if(dp[i]>maxLen){
                        maxLen=dp[i];
                        last_chosen_idx=i;
                    }
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(last_chosen_idx!=-1){
            ans.add(nums[last_chosen_idx]);
            last_chosen_idx=prev_idx[last_chosen_idx];
        }
        return ans;
    }
    private void helper(int[] nums,int idx,int prev,List<Integer> result,List<Integer> temp){
        if(idx>=nums.length){
            if(temp.size()>result.size()){
                result.clear();
                result.addAll(temp);
            }
            return;
        }

        if(prev==-1 || nums[idx]%prev==0){
            temp.add(nums[idx]);
            helper(nums,idx+1,nums[idx],result,temp);
            temp.remove(temp.size()-1);
        }
        helper(nums,idx+1,prev,result,temp);
    }
}
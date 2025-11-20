class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n=nums.length;
        int q=queries.length;
        int sumEven=0;
        for(int num:nums){
            if(num%2==0) sumEven+=num;
        }
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<q;i++){
            int val=queries[i][0];
            int idx=queries[i][1];
            if(nums[idx]%2==0)sumEven-=nums[idx];
            nums[idx]=nums[idx]+val;
            if(nums[idx]%2==0)
            sumEven+=nums[idx];
            result.add(sumEven);
        }
        int size=result.size();
        int[] ans=new int[size];
        for(int i=0;i<size;i++){
            ans[i]=result.get(i);
        }
        return ans;
    }
}
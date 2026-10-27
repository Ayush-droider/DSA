class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0,j=0,n=nums.length;
        int ans=0,maxi=0;
        while(j<n){
            ans+=nums[j];
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(map.size()<(j-i+1)){
                ans-=nums[i];
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0)map.remove(nums[i]);
                i++;
            }
            maxi=Math.max(ans,maxi);
            j++;
        }
        return maxi;
    }
}
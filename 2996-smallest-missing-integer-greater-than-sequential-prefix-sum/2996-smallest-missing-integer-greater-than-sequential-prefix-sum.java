class Solution {
    public int missingInteger(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.putIfAbsent(nums[i],i);
        }
        int sum=nums[0];
        int maxi=sum;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==(nums[i-1]+1)){
                sum+=nums[i];
                maxi=sum;
            }
            else break;
        }
        while(map.containsKey(maxi)){
            maxi=maxi+1;
        }
        return maxi;
    }
}
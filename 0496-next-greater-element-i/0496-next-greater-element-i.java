class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.putIfAbsent(nums2[i],i);
        }
        int[] ans=new int[nums1.length];
        Arrays.fill(ans,-1);
        int k=0;
        for(int num:nums1){
            int start=map.get(num);
            for(int i=start+1;i<nums2.length;i++){
                if(nums2[i]>num){
                    ans[k]=nums2[i];
                    break;
                }
            }
            k++;
        }
        return ans;
    }
}
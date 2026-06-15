class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> indices=new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            indices.put(nums2[i],i);
        }
        int[] ans=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            int val=nums1[i];
            int pos=indices.get(val);
            ans[i]=-1;
            for(int j=pos+1;j<nums2.length;j++){
                if(nums2[j]>val){
                    ans[i]=nums2[j];
                    break;
                }
            }
        }
        return ans;
    }
}
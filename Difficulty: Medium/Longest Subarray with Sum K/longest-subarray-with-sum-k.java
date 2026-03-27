// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        int sum=0;
        int maxi=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==k){
                maxi=i+1;
            }
            if(map.containsKey(sum-k)){
                maxi=Math.max(maxi,i-map.get(sum-k));
            }
            if(!map.containsKey(sum))map.put(sum,i);
        }
        return maxi;
    }
}

// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        int sum=0;
        int maxi=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(map.containsKey(sum-k)){
                int len=i-map.get(sum-k);
                maxi=Math.max(len,maxi);
            }
            if(sum==k){
                maxi=i+1;
            }
            map.putIfAbsent(sum,i);
        }
        return maxi;
    }
}

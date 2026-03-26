// User function Template for Java

class Solution {
    public int numberOfSubarrays(int[] arr, int target) {
        // code here
        return function(arr,target)-function(arr,target-1);
    }
    public int function(int[] arr,int target){
        if(target<0)return 0;
        int i=0,j=0;
        int sum=0;
        int count=0;
        
        while(j<arr.length){
            sum+=arr[j];
            
            while(sum>target){
                sum-=arr[i];
                i++;
            }
            count+=(j-i+1);
            j++;
        }
        return count;
    }
}
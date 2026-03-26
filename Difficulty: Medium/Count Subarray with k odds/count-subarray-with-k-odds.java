class Solution {
    public int countSubarrays(int[] arr, int k) {
        // code here
        return atmost(arr,k)-atmost(arr,k-1);
    }
    public int atmost(int[] arr,int k){
        if(k<0)return 0;
        
        int i=0,j=0;
        int n=arr.length;
        int count=0;
        int ans=0;
        
        while(j<n){
            if(arr[j]%2==1)count++;
            
            while(count>k){
                if(arr[i]%2!=0){
                    count--;
                }
                i++;
            }
            ans+=(j-i+1);
            j++;
        }
        return ans;
    }
}

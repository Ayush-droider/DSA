class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int n=arr.length;
        
        int i=0,j=0;
        int count=0,maxcnt=0;
        
        while(i<n){
            if(arr[i]<=dep[j]){
                count+=1;
                i+=1;
            }
            else{
                count-=1;
                j+=1;
            }
            maxcnt=Math.max(maxcnt,count);
        }
        return maxcnt;
    }
}

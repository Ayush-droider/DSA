class Solution {
    int floorSqrt(int n) {
        // code here
        int start=0;
        int end=n-1;
        int ans=0;
        if(n==1)return 1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(mid*mid<=n){
                ans=mid;
                start=start+1;
            }
            else{
                end=mid;
            }
        }
        return ans;
    }
}
class Solution {
    public int maxProduct(int n) {
        int maxi=-1,max2=-1;
        int r=0;
        while(n!=0){
            r=n%10;
            if(maxi<r){
                max2=maxi;
                maxi=r;
            }
            else if(r>max2)max2=r; 
            n/=10;
        }
        return max2*maxi;
    }
}
class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int start=1;
        int end=stalls[stalls.length-1]-stalls[0];
        while(start<=end){
            int mid=start+(end-start)/2;
            
            if(canPlace(stalls,k,mid))start=mid+1;
            else end=mid-1;
        }
        return end;
    }
    public boolean canPlace(int[] stalls,int k,int mid){
        int count=1;
        int lastplaced=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-lastplaced>=mid){
                count++;
                lastplaced=stalls[i];
            }
        }
        return count>=k;
    }
}
class Solution {
    private int clockwise(int[] dis,int s,int dest,int n){
        int ans=0;
        for(int i=s; ;i=(i+1)%n){
            if(i==dest){
                return ans;
            }
            ans+=dis[i];
        }
    }
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int ans1=clockwise(distance,start,destination,distance.length);
        int total=0;
        for(int d:distance){
            total+=d;
        }
        return Math.min(ans1,total-ans1);
    }
}
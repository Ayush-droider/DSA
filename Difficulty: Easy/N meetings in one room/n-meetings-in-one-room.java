class Solution {
    static class Data{
        int start;
        int end;
        Data(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        int n=start.length;
        Data[] data=new Data[n];
        
        for(int i=0;i<n;i++){
            data[i]=new Data(start[i],end[i]);
        }
        
        Arrays.sort(data,(a,b)->a.end-b.end);
        
        int cnt=1;
        int freetime=data[0].end;
        for(int i=1;i<n;i++){
            if(data[i].start>freetime){
                cnt++;
                freetime=data[i].end;
            }
        }
        return cnt;
    }
}

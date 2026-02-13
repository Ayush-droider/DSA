// User function Template for Java

class Solution {
    static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        int t=0,wt=0;
        for(int i=0;i<bt.length;i++){
            wt+=t;
            t+=bt[i];
        }
        return wt/bt.length;
    }
}

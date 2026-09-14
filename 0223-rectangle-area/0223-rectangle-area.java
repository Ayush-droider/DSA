class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        int area1=(ax2-ax1)*(ay2-ay1);
        int area2=(bx2-bx1)*(by2-by1);

        int[] xs = {ax1, ax2, bx1, bx2};
        Arrays.sort(xs);
        int l=0;
        if(Math.min(ax2,bx2)>Math.max(ax1,bx1)){
            l=xs[2]-xs[1];
        }
        int[] ys={ay1, ay2, by1, by2};
        Arrays.sort(ys);
        int b=0;
        if(Math.min(ay2, by2)>Math.max(ay1, by1)){
            b=ys[2]-ys[1];
        }
        int common=l*b;
        return area1+area2-(l*b);
    }
}
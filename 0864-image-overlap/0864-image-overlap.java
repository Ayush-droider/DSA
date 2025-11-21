class Solution {
    public int countOver(int[][] A, int[][] B, int n, int rowoff, int coloff){
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int ni = i + rowoff;
                int nj = j + coloff;
                if(ni < 0 || ni >= n || nj < 0 || nj >= n) continue;
                if(A[i][j] ==1 && B[ni][nj]==1) count++;
            }
        }
        return count;
    }

    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int ans = 0;

        for(int rowoff = -n + 1; rowoff < n; rowoff++){
            for(int coloff = -n + 1; coloff < n; coloff++){
                ans = Math.max(ans, countOver(img1, img2, n, rowoff, coloff));
            }
        }

        return ans;
    }
}

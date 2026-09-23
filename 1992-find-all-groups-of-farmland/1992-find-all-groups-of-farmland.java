class Solution {
    int[] dr={0,1,0,-1};
    int[] dc={-1,0,1,0};
    int er,ec;
    private void dfs(int i,int j,boolean[][] vis,int[][] land,int n,int m){
        vis[i][j]=true;
        er=Math.max(er,i);
        ec=Math.max(ec,j);
        for(int k=0;k<4;k++){
            int nr=i+dr[k];
            int nc=j+dc[k];
            if(nr>=0&&nr<n&&nc>=0&&nc<m&&!vis[nr][nc]&&land[nr][nc]==1){
                dfs(nr,nc,vis,land,n,m);
            }
        }
    }
    public int[][] findFarmland(int[][] land){
        int n=land.length;
        int m=land[0].length;
        boolean[][] vis=new boolean[n][m];
        List<List<Integer>> finalList=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(land[i][j]==1&&!vis[i][j]){
                    int sr=i,sc=j;
                    er=i;
                    ec=j;
                    dfs(i,j,vis,land,n,m);
                    List<Integer> list=new ArrayList<>();
                    list.add(sr);
                    list.add(sc);
                    list.add(er);
                    list.add(ec);
                    finalList.add(list);
                }
            }
        }
        int[][] ans=new int[finalList.size()][4];
        for(int i=0;i<finalList.size();i++){
            for(int j=0;j<4;j++){
                ans[i][j]=finalList.get(i).get(j);
            }
        }
        return ans;
    }
}
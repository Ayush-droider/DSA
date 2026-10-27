class Solution {
    public String[] createGrid(int m, int n) {
        char[][] ans=new char[m][n];
        int i=0,j=0;
        while(i<m){
            ans[i][0]='.';
            i++;
        }
        while(j<n){
            ans[m-1][j]='.';
            j++;
        }
        for(int x=0;x<m;x++){
            for(int y=0;y<n;y++){
                if(ans[x][y]!='.')ans[x][y]='#';
            }
        }
        String[] s=new String[ans.length];
        int k=0;
        for(char[] ch:ans){
            s[k++]=new String(ch);
        }
        return s;
    }
}
class Solution {
    public int[] decrypt(int[] code, int k) {
        int n=code.length;
        int[] ans=new int[n];

        if(k==0) return ans;

        int[] prefix=new int[n+1];

        for(int i=0; i<n;i++){
            prefix[i+1]=prefix[i]+code[i];
        }

        for(int i=0; i<n; i++){

            if(k>0){
                for(int j=1;j<=k;j++){
                    ans[i]+=code[(i+j)%n];
                }
            } 
            else {
                for (int j=1;j<=-k;j++){
                    ans[i]+=code[(i-j+n)%n];
                }
            }
        }

        return ans;
    }
}
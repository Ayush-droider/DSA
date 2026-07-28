class Solution {
    int count=0;
    String ans="";

    public String getPermutation(int n,int k) {
        boolean[] used=new boolean[n+1];
        helper(n,k,used,new StringBuilder());
        return ans;
    }

    private void helper(int n,int k,boolean[] used,StringBuilder sb){
        if(sb.length()==n){
            count++;
            if (count==k) {
                ans=sb.toString();
            }
            return;
        }

        for(int i=1;i<=n;i++){
            if(used[i])continue;
            used[i] = true;
            sb.append(i);
            helper(n,k,used,sb);
            used[i]=false;
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
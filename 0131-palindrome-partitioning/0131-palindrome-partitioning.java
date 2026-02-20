class Solution {
    public boolean isPalindrome(int start,int end,String s){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end))return false;
            start++;
            end--;
        }
        return true;
    }
    public void solve(int idx,String s,List<List<String>> ans,List<String> path){
        if(idx>=s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(idx,i,s)){
                path.add(s.substring(idx,i+1));
                solve(i+1,s,ans,path);
                path.remove(path.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> path=new ArrayList<>();
        solve(0,s,ans,path);
        return ans;
    }
}
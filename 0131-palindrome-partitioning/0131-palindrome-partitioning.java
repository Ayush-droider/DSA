class Solution {
    List<List<String>> ans=new ArrayList<>();
    private boolean isPalindrome(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        helper(0,s,new ArrayList<>());
        return ans;
    }
    private void helper(int idx,String s,List<String> list){
        if(idx==s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int start=idx;start<s.length();start++){
            String p=s.substring(idx,start+1);
            if(isPalindrome(p)){
                list.add(p);
                helper(start+1,s,list);
                list.remove(list.size()-1);
            }
        }
    }
}
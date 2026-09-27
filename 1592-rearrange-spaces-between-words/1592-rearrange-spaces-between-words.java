class Solution {
    public String reorderSpaces(String text) {
        int ws=0;
        for(char ch:text.toCharArray()){
            if(ch==' ')ws++;
        }
        String[] st=text.trim().split("\\s+");
        int word=st.length;
        
        if(word==1){
            return st[0]+" ".repeat(ws);
        }
        
        int between=ws/(word-1);
        int extra=ws%(word-1);
        
        StringBuilder ans=new StringBuilder();
        
        for(int i=0;i<word;i++){
            ans.append(st[i]);
            if(i!=word-1){
                ans.append(" ".repeat(between));
            }
        }
        
        ans.append(" ".repeat(extra));
        
        return ans.toString();
    }
}
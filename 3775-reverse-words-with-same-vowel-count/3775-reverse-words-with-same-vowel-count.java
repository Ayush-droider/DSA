class Solution {
    private boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')return true;
        return false;
    }
    private int countVowel(String s){
        int c=0;
        for(char ch:s.toCharArray()){
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')c++;
        }
        return c;
    }
    public String reverseWords(String s) {
        String[] str=s.split(" ");
        String st=str[0];
        int count=0;
        StringBuilder sb=new StringBuilder();
        for(char ch:st.toCharArray()){
            if(isVowel(ch))count++;
        }
        sb.append(st);

        for(int i=1;i<str.length;i++){
            sb.append(" ");
            if(countVowel(str[i])==count)sb.append(new StringBuilder(str[i]).reverse());
            else sb.append(str[i]);
        }
        return sb.toString();
    }
}
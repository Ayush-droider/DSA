class Solution {
    public boolean isValid(String s) {
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            sb.append(ch);

            if(sb.length()>=3){
                if(sb.substring(sb.length()-3,sb.length()).equals("abc")){
                    sb.deleteCharAt(sb.length()-1);
                    sb.deleteCharAt(sb.length()-1);
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        return sb.length()==0?true:false;
    }
}
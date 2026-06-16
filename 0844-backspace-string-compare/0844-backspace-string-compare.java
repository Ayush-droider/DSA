class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();

        for(char ch1:s.toCharArray()){
            if(ch1!='#')sb1.append(ch1);
            else{
                if(sb1.length()>0)sb1.deleteCharAt(sb1.length()-1);
            }
        }
        for(char ch2:t.toCharArray()){
            if(ch2!='#')sb2.append(ch2);
            else{
                if(sb2.length()>0)sb2.deleteCharAt(sb2.length()-1);
            }
        }
        return ((sb1.toString()).compareTo(sb2.toString()))==0;
    }
}
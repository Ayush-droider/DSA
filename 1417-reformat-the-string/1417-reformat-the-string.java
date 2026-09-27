class Solution{
    public String reformat(String s){
        StringBuilder letters=new StringBuilder();
        StringBuilder digits=new StringBuilder();

        for(char ch:s.toCharArray()){
            if(Character.isLetter(ch)) letters.append(ch);
            else digits.append(ch);
        }

        if(Math.abs(letters.length()-digits.length())>1)return "";

        if(digits.length()>letters.length()){
            StringBuilder temp=letters;
            letters=digits;
            digits=temp;
        }

        StringBuilder ans=new StringBuilder();
        int i=0,j=0;

        while(i<letters.length()){
            ans.append(letters.charAt(i++));
            if(j<digits.length()) ans.append(digits.charAt(j++));
        }

        return ans.toString();
    }
}
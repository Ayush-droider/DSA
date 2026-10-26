class Solution {
    //sbko T banake check kar
    //sbko F banake check kar
    //dono ka maximum
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int i=0,j=0,n=answerKey.length();
        int T=0,F=0;
        int ansT=0;
        while(j<n){
            char ch=answerKey.charAt(j);
            if(ch=='F')F++;
            while(F>k){
                char left=answerKey.charAt(i);
                if(left=='F'){
                    F--;
                }
                i++;
            }
            ansT=Math.max(ansT,j-i+1);
            j++;
        }

        i=0;j=0;T=0;F=0;
        int ansF=0;

        while(j<n){
            char ch1=answerKey.charAt(j);
            if(ch1=='T')T++;
            while(T>k){
                char left1=answerKey.charAt(i);
                if(left1=='T'){
                    T--;
                }
                i++;
            }
            ansF=Math.max(ansF,j-i+1);
            j++;
        }
        return Math.max(ansT,ansF);
    }
}
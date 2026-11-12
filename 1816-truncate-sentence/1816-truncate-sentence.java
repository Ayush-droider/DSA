class Solution {
    public String truncateSentence(String s, int k) {
        int start=0;
        int count=0;
        int len=0;
        for(String st:s.split(" ")){
            count++;
            len+=st.length();
            if(count==k)break;
            len+=1;
        }
        return s.substring(start,len);
    }
}
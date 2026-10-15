
import java.util.*;

class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        Map<Integer, Character> mp=new HashMap<>();
        char ch='a';
        for(int i=1; i<=26; i++){
            mp.put(i, ch);
            ch++;
        }

        StringBuilder sb=new StringBuilder();
        int total=0;

        for(int i=shifts.length-1; i>=0;i--){
            total=(total+shifts[i])%26;
            int pos=(s.charAt(i)-'a'+total)%26;
            sb.insert(0,mp.get(pos+1));
        }
        return sb.toString();
    }
}

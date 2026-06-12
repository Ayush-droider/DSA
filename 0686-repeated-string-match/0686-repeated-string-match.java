class Solution {
    public int repeatedStringMatch(String a, String b) {
        String y=a;
        int x=1;

        if(a.contains(b))return x;

        while(a.length()<b.length()){
            a+=y;
            x++;
            if(a.contains(b))return x;
        }

        a+=y;
        if(a.contains(b))return x+1;

        return -1;
    }
}
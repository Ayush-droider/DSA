class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set=new HashSet<>();
        int total=(int)Math.pow(2,k);
        for(int i=0;i<=s.length()-k;i++){
            set.add(s.substring(i,i+k));
        }
        return set.size()==total;
    }
}
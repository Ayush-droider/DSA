class Solution {
    public int minDeletions(String s) {
        HashMap<Character,Integer> freq=new HashMap<>();
        for(char ch:s.toCharArray()) {
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
        HashMap<Integer,Integer> mapFreq=new HashMap<>();
        for(int f:freq.values()){
            mapFreq.put(f,mapFreq.getOrDefault(f,0)+1);
        }
        int deletions=0;
        for(int f:freq.values()){
            while(f>0 && mapFreq.get(f)>1){
                mapFreq.put(f,mapFreq.get(f)-1);
                f--;
                deletions++;
                mapFreq.put(f,mapFreq.getOrDefault(f,0)+1);
            }
        }
        return deletions;
    }
}
class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> list=new ArrayList<>();
        List<Integer> a_positions=new ArrayList<>();
        List<Integer> b_positions=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.startsWith(a,i)){
                a_positions.add(i);
            }
            if(s.startsWith(b,i)){
                b_positions.add(i);
            }
        }
        for(int x:a_positions){
            for(int y:b_positions){
                if(Math.abs(x-y)<=k){
                    list.add(x);
                    break;
                }
            }
        }
        return list;
    }
}
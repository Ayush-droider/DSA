class Solution {
    List<Integer> list=new ArrayList<>();
    public List<Integer> getRow(int rowIndex) {
        list.add(1);
        helper(1,rowIndex);
        return list;
    }
    private void helper(int idx,int rowIndex){
        if(idx>rowIndex){
            return;
        }
        int prev=list.get(idx-1);

        int current=(int)((long)prev*(rowIndex-idx+1)/idx);
        list.add(current);
        helper(idx+1,rowIndex);
    }
}
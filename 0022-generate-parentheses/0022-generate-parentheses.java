class Solution {
    List<String> list=new ArrayList<>();
    private void generate(int op,int cl,String s){
        if(op==0 && cl==0){
            list.add(s);
            return;
        }
        if(op>0)generate(op-1,cl,s+"(");
        if(cl>op)generate(op,cl-1,s+")");
        //add open
        //add close
    }
    public List<String> generateParenthesis(int n) {
        generate(n,n,"");  
        return list;
    }
}
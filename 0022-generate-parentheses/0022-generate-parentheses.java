class Solution {
    List<String> list=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(n,n,new StringBuilder());
        return list;
    }
    private void helper(int op,int cl,StringBuilder sb){
        if(op==0 && cl==0){
            list.add(sb.toString());
            return;
        }
        if(op>0){
            sb.append("(");
            helper(op-1,cl,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(cl>op){
            sb.append(")");
            helper(op,cl-1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
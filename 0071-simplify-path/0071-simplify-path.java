class Solution {
    public String simplifyPath(String path) {
        Deque<String> dq=new ArrayDeque<>();
        String[] part=path.split("/");
        for(String p:part){
            if(p.equals("") || p.equals("."))continue;

            else if(p.equals("..")){
                if(!dq.isEmpty())dq.removeLast();
            }

            else{
                dq.addLast(p);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!dq.isEmpty()){
            String curr=dq.pollFirst();
            sb.append("/"+curr);
        }
        
        return (sb.length()==0)?"/":sb.toString();
    }
}
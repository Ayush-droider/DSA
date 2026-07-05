/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    static class pair{
        Node node;
        int hd;
        pair(Node node,int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null)return list;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(root,0));
        while(!q.isEmpty()){
            Node nod=q.peek().node;
            int ln=q.peek().hd;
            q.poll();
            
            map.putIfAbsent(ln,nod.data);
            
            if(nod.left!=null)q.offer(new pair(nod.left,ln-1));
            if(nod.right!=null)q.offer(new pair(nod.right,ln+1));
        }
        for(int val:map.values()){
            list.add(val);
        }
        return list;
    }
}
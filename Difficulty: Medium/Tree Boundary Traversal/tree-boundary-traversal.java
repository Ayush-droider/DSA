/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    
    boolean isLeaf(Node node){
        return (node.right==null && node.left==null);
    }
    
    void leftBoundary(Node node, ArrayList<Integer> list){
        while(node != null){
            if(!isLeaf(node)){
                list.add(node.data);
            }

            if(node.left != null)
                node = node.left;
            else
                node = node.right;
        }
    }
    
    void rightBoundary(Node node,ArrayList<Integer> list){
        Stack<Integer> st=new Stack<>();
        while(node!=null){
            if(!isLeaf(node))st.add(node.data);
            if(node.right!=null)node=node.right;
            else node=node.left;
        }
        while(!st.isEmpty()){
            list.add(st.pop());
        }
    }
    
    void addLeaves(Node node,ArrayList<Integer> list){
        if(node==null)return;
        if(isLeaf(node))list.add(node.data);
        addLeaves(node.left,list);
        addLeaves(node.right,list);
    }
    
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null)return list;
        if(!isLeaf(root))list.add(root.data);//adding root
        
        leftBoundary(root.left,list);//left Boundary
        addLeaves(root,list);//leaves
        rightBoundary(root.right,list);//right Boundary
        
        return list;
    }
}
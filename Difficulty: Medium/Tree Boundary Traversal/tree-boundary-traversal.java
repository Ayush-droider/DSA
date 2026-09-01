/* Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    ArrayList<Integer> list=new ArrayList<>();
    private boolean isLeaf(Node root){
        return root.left==null && root.right==null;
    }
    private void addLeft(Node root){
        while(root!=null){
            if(!isLeaf(root))list.add(root.data);
            if(root.left!=null)root=root.left;
            else root=root.right;
        }
    }
    private void addRight(Node root){
        Stack<Integer> st=new Stack<>();
        while(root!=null){
            if(!isLeaf(root))st.push(root.data);
            if(root.right!=null)root=root.right;
            else root=root.left;
        }
        while(!st.isEmpty()){
            list.add(st.pop());
        }
    }
    private void addLeaves(Node root){
        if(root==null)return;
        if(isLeaf(root)){
            list.add(root.data);
            return;
        }
        addLeaves(root.left);
        addLeaves(root.right);
    }
    public ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        if(root==null)return list;
        
        if(!isLeaf(root))list.add(root.data);
        addLeft(root.left);
        addLeaves(root);
        addRight(root.right);
        
        return list;
    }
}
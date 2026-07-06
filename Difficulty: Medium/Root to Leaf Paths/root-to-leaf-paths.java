/*
Definition for Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    private boolean isLeaf(Node node){
        return node.left==null && node.right==null;
    }
    private void helper(Node node,ArrayList<ArrayList<Integer>> list,ArrayList<Integer> path){
        if(node==null)return;
        path.add(node.data);
        if(isLeaf(node))list.add(new ArrayList<>(path));
        else{
            helper(node.left,list,path);
            helper(node.right,list,path);
        }
        path.remove(path.size()-1);
    }
    public ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        helper(root,list,new ArrayList<>());
        return list;
    }
}
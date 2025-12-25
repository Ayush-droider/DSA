/*
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Solution {
    public boolean isSumProperty(Node root) {
        if(root==null || (root.left==null && root.right==null))return true;
        int left=(root.left!=null)?root.left.data:0;
        int right=(root.right!=null)?root.right.data:0;
        return root.data==left+right && isSumProperty(root.left) &&isSumProperty(root.right);
    }
}
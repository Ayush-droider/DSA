/* A binary tree node class
class Node
{
    int data;
    Node left,right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
} */

class Solution {
    public int height(Node root){
        if(root==null)return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    public boolean isBalanced(Node root) {
        if(root==null)return true;
        return Math.abs(height(root.left)-height(root.right))<=1 && isBalanced(root.left)&&isBalanced(root.right); 
    }
}
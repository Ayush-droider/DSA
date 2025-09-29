/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    int diam=0;
    public int height(Node root){
        if(root==null)return 0;
        int left=height(root.left);
        int right=height(root.right);
        int dia=left+right;
        diam=Math.max(dia,diam);
        return 1+Math.max(left,right);
    }
    int diameter(Node root) {
        height(root);
        return diam;
    }
}
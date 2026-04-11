/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count=0;
    public int goodNodes(TreeNode root) {
        countNodes(root,Integer.MIN_VALUE);
        return count;
    }
    public void countNodes(TreeNode root,int maxi){
        if(root==null)return;
        if(root.val>=maxi){
            count++;
            maxi=root.val;
        }
        countNodes(root.left,maxi);
        countNodes(root.right,maxi);
    }
}
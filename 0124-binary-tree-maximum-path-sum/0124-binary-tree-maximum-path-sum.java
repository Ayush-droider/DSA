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
    int maxi=Integer.MIN_VALUE;

    private int height(TreeNode root){
        if(root==null)return 0;
        int left=Math.max(0,height(root.left));
        int right=Math.max(0,height(root.right));
        int sum=left+right+root.val;
        maxi=Math.max(sum,maxi);
        return root.val+Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
        height(root);
        return maxi;
    }
}
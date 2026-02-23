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
    Map<TreeNode , Integer> map;
    public int rob(TreeNode root) {
        map = new HashMap<>();
        return helper(root);
    }
    public int helper(TreeNode root){
        if(root==null)return 0;

        if(root.left==null && root.right==null)return root.val;

        if(map.containsKey(root)) return map.get(root);

        int leftleft=0,leftright=0;

        if(root.left!=null){
            leftleft=helper(root.left.left);
            leftright=helper(root.left.right);
        }

        int rightleft=0,rightright=0;

        if(root.right!=null){
            rightright=helper(root.right.right);
            rightleft=helper(root.right.left);
        }
        int take=0;
        take=root.val+leftleft+leftright+rightleft+rightright;
        int nottake=0+helper(root.left)+helper(root.right);
        map.put(root , Math.max(take,nottake));
        return map.get(root);
    }
}
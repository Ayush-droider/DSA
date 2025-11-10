class Solution {
    private int maxi = Integer.MIN_VALUE; 
    public int maxPathSum(TreeNode root) {
        height(root);
        return maxi;
    }
    private int height(TreeNode node) {
        if (node == null) return 0;
        int lh = Math.max(0, height(node.left));
        int rh = Math.max(0, height(node.right));
        maxi = Math.max(maxi, node.val + lh + rh);
        return node.val + Math.max(lh, rh);
    }
}

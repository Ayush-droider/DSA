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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        boolean rev = false;
        while (!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (!rev) {
                    TreeNode curr = dq.removeFirst();
                    level.add(curr.val);
                    if (curr.left != null)
                        dq.addLast(curr.left);
                    if (curr.right != null)
                        dq.addLast(curr.right);
                } else {
                    TreeNode curr = dq.removeLast();
                    level.add(curr.val);
                    if (curr.right != null)
                        dq.addFirst(curr.right);
                    if (curr.left != null)
                        dq.addFirst(curr.left);
                }
            }
            ans.add(level);
            rev=!rev;
        }
        return ans;
    }
}
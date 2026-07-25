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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        boolean odd=false;
        while (!q.isEmpty()) {
            int size = q.size();
            List<TreeNode> level=new ArrayList<>();
            for (int i=0;i<size;i++) {
                TreeNode node=q.poll();
                level.add(node);

                if (node.left!=null) q.offer(node.left);
                if (node.right!=null) q.offer(node.right);
            }

            if(odd){
                int i=0;
                int j=level.size() - 1;
                while(i<j){
                    int temp=level.get(i).val;
                    level.get(i).val=level.get(j).val;
                    level.get(j).val=temp;
                    i++;
                    j--;
                }
            }
            odd=!odd;
        }
        return root;
    }
}
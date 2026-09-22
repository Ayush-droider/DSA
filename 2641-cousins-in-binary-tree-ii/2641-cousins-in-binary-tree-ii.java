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
    public TreeNode replaceValueInTree(TreeNode root) {
        if(root==null) return null;
        root.val=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();

            List<TreeNode> currentLevel=new ArrayList<>();
            int levelSum=0;

            for(int i=0; i<size; i++){
                TreeNode node=q.poll();
                currentLevel.add(node);

                if(node.left!=null)levelSum+=node.left.val;

                if(node.right!=null)levelSum+=node.right.val;
            }

            for(TreeNode node:currentLevel){
                int siblingSum=0;

                if(node.left!=null)siblingSum+=node.left.val;

                if(node.right!=null)siblingSum+=node.right.val;

                if(node.left!=null){
                    node.left.val=levelSum-siblingSum;
                    q.offer(node.left);
                }

                if(node.right != null) {
                    node.right.val=levelSum-siblingSum;
                    q.offer(node.right);
                }
            }
        }
        return root;
    }
}
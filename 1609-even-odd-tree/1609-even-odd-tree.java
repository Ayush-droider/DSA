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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean flag=true;
        while(!q.isEmpty()){
            int size=q.size();
            TreeNode prev=null;
            if(flag){
                for(int i=0;i<size;i++){
                    TreeNode curr=q.poll();
                    if((curr.val%2==1) && (prev == null || curr.val>prev.val)){
                        prev=curr;
                        if(curr.left!=null)q.add(curr.left);
                        if(curr.right!=null)q.add(curr.right);
                    }
                    else return false;
                }
            }
            else{
                for(int i=0;i<size;i++){
                    TreeNode curr=q.poll();
                    if((curr.val%2==0) && (prev == null || curr.val<prev.val)){
                        prev=curr;
                        if(curr.left!=null)q.add(curr.left);
                        if(curr.right!=null)q.add(curr.right);
                    }
                    else return false;
                }
            }
            flag=!flag;
        }
        return true;
    }
}
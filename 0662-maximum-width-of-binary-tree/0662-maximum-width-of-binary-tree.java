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
    private class pair{
        TreeNode node;
        int num;
        pair(TreeNode node,int num){
            this.node=node;
            this.num=num;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth=0;
        if(root==null)return 0;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int mini=q.peek().num;
            int first=0,second=0;
            for(int i=0;i<size;i++){
                pair p=q.poll();
                int id=p.num-mini;
                TreeNode curr=p.node;
                if(i==0)first=id;
                if(i==size-1)second=id;
                if(curr.left!=null)q.add(new pair(curr.left,id*2+1));
                if(curr.right!=null)q.add(new pair(curr.right,id*2+2));
            }
            maxWidth=Math.max(maxWidth,second-first+1);
        }
        return maxWidth;
    }
}
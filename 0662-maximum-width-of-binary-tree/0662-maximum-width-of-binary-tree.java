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
    private class Pair{
        TreeNode node;
        int num;
        Pair(TreeNode node,int num){
            this.node=node;
            this.num=num;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;

        int width=0;

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));

        while(!q.isEmpty()){
            int size=q.size();
            int mini=q.peek().num;

            int first=0,last=0;
            for(int i=0;i<size;i++){
                Pair p=q.poll();
                TreeNode currnode=p.node;
                int curr=p.num-mini;

                if(i==0)first=curr;
                if(i==size-1)last=curr;

                if(currnode.left!=null)q.add(new Pair(currnode.left,2*curr+1));
                if(currnode.right!=null)q.add(new Pair(currnode.right,2*curr+2));
            }
            width=Math.max(width,(last-first+1));
        }

        return width;
    }
}
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
        long idx;
        Pair(TreeNode node,long idx){
            this.node=node;
            this.idx=idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));

        int ans=0;

        while(!q.isEmpty()){
            int size=q.size();

            long mini=q.peek().idx;
            long first=0;
            long last=0;

            for(int j=0;j<size;j++){
                Pair p=q.poll();

                TreeNode curr=p.node;
                long i=p.idx-mini;

                if(j==0)first=i;
                if(j==size-1)last=i;

                if(curr.left!=null)q.add(new Pair(curr.left,2*i));
                if(curr.right!=null)q.add(new Pair(curr.right,2*i+1));
            }
            ans=Math.max(ans,(int)(last-first+1));
        }
        return ans;
    }
}
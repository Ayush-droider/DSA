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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> pq=new LinkedList<>();
        pq.add(root);
        List<Long> list=new ArrayList<>();
        while(!pq.isEmpty()){
            int size=pq.size();
            long sum=0;
            for(int i=0;i<size;i++){
                TreeNode curr=pq.poll();
                sum+=curr.val;

                if(curr.right!=null){
                    pq.add(curr.right);
                }

                if(curr.left!=null){
                    pq.add(curr.left);
                }
            }
            list.add(sum);
        }
        Collections.sort(list,Collections.reverseOrder());

        if(k>list.size())return -1;

        return list.get(k-1);
    }
}
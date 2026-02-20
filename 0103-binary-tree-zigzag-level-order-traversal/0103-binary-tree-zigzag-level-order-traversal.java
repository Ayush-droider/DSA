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

        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;

        Deque<TreeNode> dq=new LinkedList<>();
        dq.offer(root);

        boolean rev=false;

        while(!dq.isEmpty()){

            int size=dq.size();
            LinkedList<Integer> list=new LinkedList<>();

            for(int i=0;i<size;i++){

                if(!rev){
                    TreeNode node=dq.removeFirst();
                    list.addLast(node.val);

                    if(node.left!=null) dq.addLast(node.left);
                    if(node.right!=null) dq.addLast(node.right);
                }
                else{
                    TreeNode node=dq.removeLast();
                    list.addLast(node.val);

                    if(node.right!=null) dq.addFirst(node.right);
                    if(node.left!=null) dq.addFirst(node.left);
                }
            }

            ans.add(list);
            rev = !rev;
        }
        return ans;
    }
}
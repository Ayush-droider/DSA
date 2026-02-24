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
    List<List<Integer>> list=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum,new ArrayList<>());
        return list;
    }
    public void dfs(TreeNode root,int targetSum,List<Integer> inlist){
        if(root==null)return;

        inlist.add(root.val);
        
        if(root.left==null && root.right==null && root.val==targetSum){
            list.add(new ArrayList<>(inlist));
        }
        
        dfs(root.left,targetSum-root.val,inlist);
        dfs(root.right,targetSum-root.val,inlist);

        inlist.remove(inlist.size() - 1);
    }
}
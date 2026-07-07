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
    List<List<Integer>> ans;
    private boolean isLeaf(TreeNode root){
        return root.left==null && root.right==null;
    }
    private void helper(TreeNode root,int target,List<List<Integer>> ans,List<Integer> path,int sum){
        if(root==null)return;
        sum+=root.val;
        path.add(root.val);
        if(isLeaf(root)){
            if(target==sum)ans.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        helper(root.left,target,ans,path,sum);
        helper(root.right,target,ans,path,sum);

        path.remove(path.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans=new ArrayList<>();
        helper(root,targetSum,ans,new ArrayList<>(),0);
        return ans;
    }
}
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
    HashMap<Integer,Integer> map=new HashMap<>();
    int ans=0;
    public int pathSum(TreeNode root, int targetSum) {
        int sum=0;
        dfs(root,targetSum,sum);
        return ans;
    }
    public void dfs(TreeNode root,int targetSum,int sum){
        if(root==null)return;

        if(root.val>=1000000000){
            dfs(root.left,targetSum,sum);
            dfs(root.right,targetSum,sum);
            return;
        }

        sum+=root.val;

        if(sum==targetSum)ans+=1;

        if(map.containsKey(sum-targetSum))ans+=map.get(sum-targetSum);

        map.put(sum,map.getOrDefault(sum,0)+1);

        dfs(root.left,targetSum,sum);
        dfs(root.right,targetSum,sum);

        map.put(sum,map.get(sum)-1);
    }
}
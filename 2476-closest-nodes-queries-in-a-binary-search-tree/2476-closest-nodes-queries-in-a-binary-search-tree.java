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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans=new ArrayList<>();
        //get sorted tree i.e preorder
        List<Integer> preorder=new ArrayList<>();
        preorder(root,preorder);

        //now using binary search search for those element
        for(int q:queries){
            int left=0,right=preorder.size()-1;
            int floor=-1,ceil=-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(preorder.get(mid)==q){
                    ceil=floor=q;
                    break;
                }
                else if(preorder.get(mid)<q){
                    floor=preorder.get(mid);
                    left=mid+1;
                }
                else{
                    ceil=preorder.get(mid);
                    right=mid-1;
                }
            }
            List<Integer> list=new ArrayList<>();
            list.add(floor);
            list.add(ceil);
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
    private void preorder(TreeNode root,List<Integer> preorder){
        if(root==null)return ;

        preorder(root.left,preorder);
        preorder.add(root.val);
        preorder(root.right,preorder);
    }
    
}
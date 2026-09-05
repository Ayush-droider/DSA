/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void markParent(TreeNode root,Map<TreeNode,TreeNode> parent){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr.left!=null){
                q.add(curr.left);
                parent.put(curr.left,curr);
            }
            if(curr.right!=null){
                q.add(curr.right);
                parent.put(curr.right,curr);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list=new ArrayList<>();
        Map<TreeNode,TreeNode> parent=new HashMap<>();
        markParent(root,parent);
        Map<TreeNode,Boolean> vis=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(target);
        vis.put(target,true);
        int currLvl=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(currLvl==k)break;
            currLvl++;
            
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null && !vis.containsKey(curr.left)){
                    q.add(curr.left);
                    vis.put(curr.left,true);
                }
                if(curr.right!=null && !vis.containsKey(curr.right)){
                    q.add(curr.right);
                    vis.put(curr.right,true);
                }
                if(parent.get(curr)!=null && !vis.containsKey(parent.get(curr))){
                    q.add(parent.get(curr));
                    vis.put(parent.get(curr),true);
                }
            }
        }
        while(!q.isEmpty()){
            list.add(q.poll().val);
        }
        return list;
    }
}
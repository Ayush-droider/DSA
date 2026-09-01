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
        int line;
        int level;
        Pair(TreeNode node, int line, int level){
            this.node=node;
            this.line=line;
            this.level=level;
        }
    }

    List<List<Integer>> list=new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root){
        if(root==null)return list;
        HashMap<Integer, List<Pair>> map=new HashMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0,0));
        int min=0;
        int max=0;
        while(!q.isEmpty()){
            Pair p=q.poll();
            TreeNode curr=p.node;
            int line=p.line;
            int level=p.level;
            map.putIfAbsent(line,new ArrayList<>());
            map.get(line).add(p);
            min=Math.min(min,line);
            max=Math.max(max,line);

            if (curr.left!=null)q.add(new Pair(curr.left,line-1,level+1));

            if (curr.right!=null)q.add(new Pair(curr.right,line+1,level+1));
        }
        for(int i=min;i<=max;i++){
            if(map.containsKey(i)){
                List<Pair> temp=map.get(i);
                Collections.sort(temp,(a,b)->{
                    if(a.level!=b.level)return a.level-b.level;
                    return a.node.val-b.node.val;
                });
                List<Integer> ans=new ArrayList<>();
                for(Pair p:temp){
                    ans.add(p.node.val);
                }
                list.add(ans);
            }
        }
        return list;
    }
}
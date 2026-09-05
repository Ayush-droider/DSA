class Solution {
    private class Pair{
        TreeNode node;
        int tm;

        Pair(TreeNode node,int tm){
            this.node=node;
            this.tm=tm;
        }
    }
    private void markParent(TreeNode root,Map<TreeNode,TreeNode> parent){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode curr=q.poll();

            if(curr.left!=null){
                parent.put(curr.left,curr);
                q.add(curr.left);
            }

            if(curr.right!=null){
                parent.put(curr.right,curr);
                q.add(curr.right);
            }
        }
    }

    public int amountOfTime(TreeNode root, int start) {

        Map<TreeNode,TreeNode> parent=new HashMap<>();

        markParent(root,parent);

        TreeNode startNode=null;
        Queue<TreeNode> temp=new LinkedList<>();
        temp.add(root);

        while(!temp.isEmpty()){
            TreeNode curr=temp.poll();

            if(curr.val==start){
                startNode=curr;
                break;
            }

            if(curr.left!=null){
                temp.add(curr.left);
            }

            if(curr.right!=null){
                temp.add(curr.right);
            }
        }

        Queue<Pair> q=new LinkedList<>();
        Map<TreeNode,Boolean> vis=new HashMap<>();

        q.add(new Pair(startNode,0));
        vis.put(startNode,true);

        int mini=0;

        while(!q.isEmpty()){

            Pair p=q.poll();

            TreeNode curr=p.node;
            int tm=p.tm;

            mini=Math.max(mini,tm);

            if(curr.left!=null && !vis.containsKey(curr.left)){
                vis.put(curr.left,true);
                q.add(new Pair(curr.left,tm+1));
            }

            if(curr.right!=null && !vis.containsKey(curr.right)){
                vis.put(curr.right,true);
                q.add(new Pair(curr.right,tm+1));
            }

            if(parent.containsKey(curr) && !vis.containsKey(parent.get(curr))){
                TreeNode par=parent.get(curr);

                vis.put(par,true);
                q.add(new Pair(par,tm+1));
            }
        }

        return mini;
    }
}
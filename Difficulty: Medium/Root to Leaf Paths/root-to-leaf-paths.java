/* Definition for Node
class Node
{
    int data;
    Node left;
    Node right;
    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> paths(Node root) {
        // code here
        helper(root,new ArrayList<>());
        return ans;
    }
    
    private void helper(Node root,ArrayList<Integer> list){
        if(root==null)return;
        if(root.left==null && root.right==null){
            list.add(root.data);
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(root.data);
        helper(root.left,new ArrayList<>(list));
        helper(root.right,new ArrayList<>(list));
    }
}
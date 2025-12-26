/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {

    public static boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    public static void getPath(
            Node root,
            ArrayList<Integer> path,
            ArrayList<ArrayList<Integer>> result) {

        if (root == null) return;

        path.add(root.data);

        if (isLeaf(root)) {
            result.add(new ArrayList<>(path));
        } else {
            getPath(root.left, path, result);
            getPath(root.right, path, result);
        }
        path.remove(path.size() - 1);
    }

    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        getPath(root, new ArrayList<>(), result);
        return result;
    }
}

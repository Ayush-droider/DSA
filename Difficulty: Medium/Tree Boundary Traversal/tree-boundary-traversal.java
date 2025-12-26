/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {

    boolean isLeaf(Node node) {
        return node != null && node.left == null && node.right == null;
    }

    void addLeftBoundary(Node node, ArrayList<Integer> list) {
        while (node != null) {
            if (!isLeaf(node))
                list.add(node.data);

            if (node.left != null)
                node = node.left;
            else
                node = node.right;
        }
    }

    void addLeaves(Node node, ArrayList<Integer> list) {
        if (node == null) return;

        if (isLeaf(node)) {
            list.add(node.data);   
            return;
        }

        addLeaves(node.left, list);
        addLeaves(node.right, list);
    }

    void addRightBoundary(Node node, ArrayList<Integer> list) {
        Stack<Integer> st = new Stack<>();

        while (node != null) {
            if (!isLeaf(node))
                st.push(node.data);

            if (node.right != null)
                node = node.right;
            else
                node = node.left;
        }

        while (!st.isEmpty())
            list.add(st.pop());
    }

    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;

        if (!isLeaf(root))
            list.add(root.data);

        addLeftBoundary(root.left, list);
        addLeaves(root, list);
        addRightBoundary(root.right, list);  

        return list;
    }
}

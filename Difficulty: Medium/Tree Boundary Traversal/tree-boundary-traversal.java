class Solution {

    boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    void addLeft(Node node, ArrayList<Integer> list) {
        while (node != null) {
            if (!isLeaf(node)) {
                list.add(node.data);
            }
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
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

    void addRight(Node node, ArrayList<Integer> list) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            if (!isLeaf(node)) {
                stack.push(node.data);
            }
            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
    }

    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;

        if (!isLeaf(root)) {
            list.add(root.data);
        }

        addLeft(root.left, list);     // Left boundary
        addLeaves(root, list);        // Leaf nodes
        addRight(root.right, list);   // Right boundary

        return list;
    }
}

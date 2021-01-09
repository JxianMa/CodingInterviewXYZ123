package DataStructure.Tree;

public class BST {
    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public Node insertToBST(Node root, int val) {
        if (root == null) return new Node(val);
        if (root.data < val) {
            root.right = insertToBST(root.right, val);
        } else {
            root.left = insertToBST(root.left, val);
        }
        return root;
    }

    public Node lca(Node root, int v1, int v2) {
        if (root == null) return null;
        if (root.data == v1) return root;
        if (root.data == v2) return root;
        Node left = lca(root.left, v1, v2);
        Node right = lca(root.right, v1, v2);
        if (left != null && right != null) return root;
        else if (left == null && right != null) return right;
        else return left;
    }

    public Node constructBSTFromPre(int[] pre) {
        if (pre == null || pre.length == 0) return null;
        return constructBST(pre, 0, pre.length - 1);
    }

    private Node constructBST(int[] pre, int i, int j) {
        if (i > j) return null;
        Node root = new Node(pre[i]);
        int lSize = 0;
        for (int t = i; t <= j; t++) {
            if (pre[t] < pre[i]) lSize++;
        }
        root.left = constructBST(pre, i + 1, i + lSize);
        root.right = constructBST(pre, i + lSize + 1, j);
        return root;
    }
}

package DataStructure.Tree;

import java.util.*;

public class Traversals {

    public void preorder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.item.toString());
        preorder(root.left);
        preorder(root.right);
    }

    public void preorder_iterative(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.println(cur);
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.item.toString());
        inorder(root.right);
    }

    public void inorder_iterative(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode t = root;
        stack.push(t);
        while (!stack.isEmpty() || t != null) {
            if (t != null && t.left != null) {
                stack.push(t.left);
                t = t.left;
            } else {
                TreeNode out = stack.pop();
                System.out.println(out.item);
                if (out.right != null) {
                    t = out.right;
                    stack.push(out.right);
                }
            }
        }
    }

    public void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.item.toString());
    }

    public void postorder_iterative(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> traverseStack = new ArrayDeque<>();
        Deque<TreeNode> outputStack = new ArrayDeque<>();
        traverseStack.push(root);
        while (!traverseStack.isEmpty()) {
            TreeNode cur = traverseStack.pop();
            outputStack.push(cur);
            if (cur.right != null) {
                traverseStack.push(cur.right);
            }
            if (cur.left != null) {
                traverseStack.push(cur.left);
            }
        }
        while (!outputStack.isEmpty()) {
            System.out.print(outputStack.pop().item + " ");
        }
    }


    // BFS -
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList();
        if (root == null) return ret;
        Queue<TreeNode> q = new ArrayDeque();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> curLvl = new ArrayList();
            int curLvlSize = q.size();
            for (int i = 0; i < curLvlSize; i++) {
                TreeNode node = q.poll();
                curLvl.add((Integer) node.item);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            ret.add(curLvl);
        }
        return ret;
    }
}

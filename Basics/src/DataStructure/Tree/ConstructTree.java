package DataStructure.Tree;

public class ConstructTree {
    public TreeNode fromPreAndIn(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) return null;
        return constructFromPreAndIn(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode constructFromPreAndIn(int[] pre, int i, int j, int[] in, int p, int q) {
        if (i > j || p > q) return null;
        TreeNode curRoot = new TreeNode(pre[i]);
        int rootIdx = 0;
        for (int t = p; i <= q; i++) {
            if (in[t] == pre[i]) {
                rootIdx = t;
                break;
            }
        }
        int lSize = rootIdx - p;
        curRoot.left = constructFromPreAndIn(pre, i + 1, i + lSize, in, p, rootIdx - 1);
        curRoot.right = constructFromPreAndIn(pre, i + lSize + 1, j, in, rootIdx + 1, q);
        return curRoot;
    }


    public TreeNode fromInAndPost(int[] in, int[] post) {
        if (in == null || post == null || in.length == 0 || post.length == 0) return null;
        return constructFromInAndPost(in, 0, in.length, post, 0, post.length);
    }

    private TreeNode constructFromInAndPost(int[] in, int i, int j, int[] post, int p, int q) {
        if (i > j || p > q) return null;
        TreeNode root = new TreeNode(post[q]);
        int rootIdx = 0;
        for (int t = i; t <= j; t++) {
            if (in[t] == post[q]) {
                rootIdx = t;
                break;
            }
        }
        int leftTreeSize = rootIdx - i;
        root.left = constructFromInAndPost(in, i, rootIdx - 1, post, p, p + leftTreeSize - 1);
        root.right = constructFromInAndPost(in, rootIdx + 1, j, post, p + leftTreeSize, q - 1);
        return root;
    }

    public TreeNode fromPreAndPost(int[] pre, int[] post) {
        if (pre == null || post == null || pre.length == 0 || post.length == 0) return null;
        return constructFromPreAndPost(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    private TreeNode constructFromPreAndPost(int[] pre, int i, int j, int[] post, int p, int q) {
        if (p == q) return new TreeNode(post[p]);
        if (i > j || p > q) return null;
        TreeNode root = new TreeNode(post[q]);
        int rightRoot = 0;
        for (int t = i; t <= j; t++) {
            if (pre[t] == post[q - 1]) {
                rightRoot = t;
                break;
            }
        }
        int rSize = j - rightRoot + 1;
        int lSize = rightRoot - i - 1;
        root.left = constructFromPreAndPost(pre, i + 1, rightRoot - 1, post, p, p + lSize - 1);
        root.right = constructFromPreAndPost(pre, rightRoot, j, post, q - rSize, q - 1);
        return root;
    }
}

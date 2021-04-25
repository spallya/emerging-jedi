public class IsSubTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String p1 = preOrder(s);
        String p2 = preOrder(t);
        return p1.contains(p2);
    }

    private String preOrder(TreeNode t) {
        if (t == null) {
            return "null";
        }
        return "#" + t.val + " " + preOrder(t.left) + " " + preOrder(t.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
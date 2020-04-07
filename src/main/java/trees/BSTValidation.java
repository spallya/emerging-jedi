package trees;

public class BSTValidation {

    public static void main(String[] args) {
        TreeUtils bstTree = new TreeUtils();
        TreeUtils notBstTree = new TreeUtils();
        TreeUtils.Node bstRoot = null;
        TreeUtils.Node notBstRoot = null;
        notBstRoot = notBstTree.insert(5, notBstRoot);
        notBstRoot = notBstTree.insert(1, notBstRoot);
        notBstRoot = notBstTree.insert(4, notBstRoot);
        notBstRoot = notBstTree.insert(0, notBstRoot);
        notBstRoot = notBstTree.insert(0, notBstRoot);
        notBstRoot = notBstTree.insert(3, notBstRoot);
        notBstRoot = notBstTree.insert(6, notBstRoot);
        bstRoot = bstTree.insert(10, bstRoot);
        bstRoot = bstTree.insert(15, bstRoot);
        bstRoot = bstTree.insert(-10, bstRoot);
        bstRoot = bstTree.insert(17, bstRoot);
        bstRoot = bstTree.insert(20, bstRoot);
        bstRoot = bstTree.insert(0, bstRoot);
        System.out.println("Tree is BST or not ? " + notBstTree.isValidBST(notBstRoot));
        System.out.println("Tree is BST or not ? " + bstTree.isValidBST(bstRoot));
    }
}
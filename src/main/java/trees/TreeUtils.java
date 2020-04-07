package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeUtils {

    static class Node {
        int data;
        Node left, right;

        static Node newNode(int data) {
            Node n = new Node();
            n.left = null;
            n.right = null;
            n.data = data;
            return n;
        }
    }

    public Node insert(int data, Node root) {
        Node tempRoot = root;
        Node node = Node.newNode(data);
        if (root == null) {
            root = node;
            return root;
        }

        Node parent = null, current = root;
        while (current != null) {
            parent = current;
            if (current.data < data) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        if (parent.data < data) {
            parent.right = node;
        } else {
            parent.left = node;
        }
        return tempRoot;
    }

    public boolean isBST(Node root, int min, int max) {
        if (root == null)
            return true;
        if (root.data <= min || max <= root.data)
            return false;
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }

    public boolean isValidBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isSymmetric(Node t1, Node t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        return (t1.data == t2.data)
                && isSymmetric(t1.left, t2.right)
                && isSymmetric(t1.right, t2.left);
    }

    public boolean isValidSymmetric(Node root) {
        return isSymmetric(root, root);
    }

    public List<List<Integer>> levelOrderBottom(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        List<List<Integer>> listResult = new LinkedList<List<Integer>>();

        if (root == null) return listResult;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().data);
            }
            listResult.add(0, subList);
        }
        return listResult;
    }

    public boolean hasPathSum(Node root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.data == sum && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
    }

    public Node mergeTrees(Node t1, Node t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.data += t2.data;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
package Simple;


import Tree.TreeNode;

public class No104 {
    public static void main(String[] args) {
        No104 test = new No104();
        test.recursion(null,0);
    }
    int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        recursion(root, 1);
        return maxDepth;
    }

    public void recursion(TreeNode node, int depth) {
        if (node.left != null) {
            recursion(node.left, depth + 1);
        }
        if (node.right != null) {
            recursion(node.right, depth + 1);
        }
        // 到这里，说明节点node是叶子节点
        maxDepth = depth > maxDepth ? depth : maxDepth;
    }
}

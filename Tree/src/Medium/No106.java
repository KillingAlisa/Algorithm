package Medium;

import Tree.TreeNode;

import java.util.HashMap;

public class No106 {
    int[] postorder;
    int[] inorder;
    int len;
    int rootIndex;
    HashMap<Integer,Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        this.len = inorder.length;
        this.rootIndex = len - 1;
        for (int i = 0; i < len; i++) {
            inorderMap.put(inorder[i] , i);
        }
        return helper(0, len - 1);
    }

    public TreeNode helper (int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        int rootVal = postorder[rootIndex];
        int inIndex = inorderMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        rootIndex--;
        root.right = helper(inIndex + 1,inRight);
        root.left = helper(inLeft , inIndex - 1);
        return root;
    }
}
class Test {
    public static void main(String[] args) {
        No106 test = new No106();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        test.buildTree(inorder,postorder);
    }
}

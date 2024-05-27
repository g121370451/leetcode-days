package leetcode_days.hot_100.tree;

import leetcode_days.data_struct.TreeNode;

// S543 二叉树的直径
public class S543 {
    Integer res;
    public int getHigh(TreeNode node) {
        int left = 0, right = 0;
        if (node.left != null) {
            left = getHigh(node.left);
        }
        if (node.right != null) {
            right = getHigh(node.right);
        }
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        getHigh(root);
        return res;
    }

    public static void main(String[] args) {
        S543 s543 = new S543();
        TreeNode node = TreeNode.buildTreeNodeBySpecialArray(new Integer[]{1, 2, 3, 4, 5});
        System.out.println(s543.diameterOfBinaryTree(node));
    }
}

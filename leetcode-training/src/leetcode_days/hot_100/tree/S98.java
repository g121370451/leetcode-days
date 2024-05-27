package leetcode_days.hot_100.tree;

import leetcode_days.data_struct.TreeNode;

import java.util.Stack;

// 98. 验证二叉搜索树
public class S98 {


    public boolean isValidBSTWrong(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
        long min = Long.MIN_VALUE;
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root.val <= min) {
                return false;
            }
            min = root.val;
            if (root.right != null) {
                stack.push(root.right);
                while (stack.peek().left != null) {
                    stack.push(stack.peek().left);
                }
            }
        }
        return true;
    }
    long min = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root.left != null) {
            if (!isValidBST(root.left)) {
                return false;
            }
        }
        if (root.val <= min) {
            return false;
        }
        min = root.val;
        if (root.right != null) {
            return isValidBST(root.right);
        }
        return true;
    }

    public static void main(String[] args) {
        S98 s98 = new S98();
//        TreeNode node = TreeNode.buildTreeNodeBySpecialArray(new Integer[]{5, 1, 4, null, null, 3, 6});
//        TreeNode node = TreeNode.buildTreeNodeBySpecialArray(new Integer[]{3,null,30,10,null,null,15,null,45});
        TreeNode node = TreeNode.buildTreeNodeBySpecialArray(new Integer[]{Integer.MIN_VALUE, 5, 1, 4, 30, 10});
        System.out.println(node);
        System.out.println(s98.isValidBST(node));
    }
}

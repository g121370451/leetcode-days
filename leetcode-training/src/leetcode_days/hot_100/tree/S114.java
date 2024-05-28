package leetcode_days.hot_100.tree;

import leetcode_days.data_struct.TreeNode;

// 114. 二叉树展开为链表
public class S114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.right!=null){
            flatten(root.right);
        }
        if (root.left != null) {
            flatten(root.left);
            if (root.right != null) {
                TreeNode temp = root.right;
                root.right = root.left;
                root.left = null;
                while (root.right != null) {
                    root = root.right;
                }
                root.right = temp;
            } else {
                root.right = root.left;
                root.left = null;
            }
        }
    }

    public static void main(String[] args) {
        S114 s114 = new S114();
//        TreeNode node = TreeNode.buildTreeNodeBySpecialArray(new Integer[]{1, 2, 5, 3, 4, null, 6});
        TreeNode node = TreeNode.buildTreeNodeBySpecialArray(new Integer[]{1, null, 2, 3});
        System.out.println(node);
        s114.flatten(node);
        System.out.println(node);
    }
}

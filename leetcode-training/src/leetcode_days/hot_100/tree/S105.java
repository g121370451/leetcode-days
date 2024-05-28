package leetcode_days.hot_100.tree;

import leetcode_days.data_struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

// 105. 从前序与中序遍历序列构造二叉树
public class S105 {

    public TreeNode buildTree(int[] preorder, int[] inorder, int size, int preStart, int inStart) {
        int pivot = preorder[preStart];
        TreeNode root = new TreeNode(pivot);
        for (int i = inStart; i < inStart + size; i++) {
            if (inorder[i] == pivot) {
                int sizeLeft = i - inStart;
                int sizeRight = size + inStart - 1 - i;
                if (sizeLeft != 0) {
                    root.left = buildTree(preorder, inorder, sizeLeft, preStart + 1, i - sizeLeft);
                }
                if (sizeRight != 0) {
                    root.right = buildTree(preorder, inorder, sizeRight, preStart + 1 + sizeLeft, i + 1);
                }
            }
        }
        return root;
    }

    public TreeNode buildTreeWrong(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, preorder.length, 0, 0);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        Map<Integer, Integer> index = new HashMap<>(n); // 预分配空间
        for (int i = 0; i < n; i++) {
            index.put(inorder[i], i);
        }
        return dfs(preorder, 0, n, 0, index); // 左闭右开区间
    }

    private TreeNode dfs(int[] preorder, int preL, int preR, int inL, Map<Integer, Integer> index) {
        if (preL == preR) { // 空节点
            return null;
        }
        int leftSize = index.get(preorder[preL]) - inL; // 左子树的大小
        TreeNode left = dfs(preorder, preL + 1, preL + 1 + leftSize, inL, index);
        TreeNode right = dfs(preorder, preL + 1 + leftSize, preR, inL + 1 + leftSize, index);
        return new TreeNode(preorder[preL], left, right);
    }


    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
        S105 s105 = new S105();
        System.out.println(s105.buildTree(preorder, inorder));
    }
}

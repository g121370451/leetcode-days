package leetcode_days.hot_100.tree;

import leetcode_days.data_struct.TreeNode;

import java.util.ArrayDeque;

// 230. 二叉搜索树中第K小的元素
// 不要使用Stack 巨慢 占用内存也大 同样的结构 使用ArrayDeque会快很多？？ 为什么 因为Stack继承Vector 对每个操作都加了锁synchronized
public class S230 {
    public int kthSmallest(TreeNode root, int k) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                if (--k == 0) {
                    return pop.val;
                }
                root = pop.right;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        S230 s230 = new S230();
        TreeNode node = TreeNode.buildTreeNodeBySpecialArray(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        System.out.println(node);
        System.out.println(s230.kthSmallest(node, 5));
    }
}

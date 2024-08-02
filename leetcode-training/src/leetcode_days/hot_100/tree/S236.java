package leetcode_days.hot_100.tree;

import com.sun.source.tree.Tree;
import leetcode_days.data_struct.TreeNode;

import java.util.ArrayDeque;

// 236. 二叉树的最近公共祖先
// 中序遍历
public class S236 {
    ArrayDeque<Tree> nodeStack = new ArrayDeque<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return null;
    }

    public static void main(String[] args) {
        S236 s236 = new S236();
        TreeNode node = TreeNode.buildTreeNodeBySpecialArray(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        s236.lowestCommonAncestor(node, node.left, node.right);
    }
}

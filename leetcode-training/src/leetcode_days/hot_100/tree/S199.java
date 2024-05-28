package leetcode_days.hot_100.tree;

import leetcode_days.data_struct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//199. 二叉树的右视图
public class S199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(root);
        int count = 1;
        int temp = 0;

        while (!arrayDeque.isEmpty()) {
            while (count > 0) {
                TreeNode poll = arrayDeque.poll();
                assert poll != null;
                --count;
                if (count == 0) {
                    res.add(poll.val);
                }
                if (poll.left != null) {
                    arrayDeque.add(poll.left);
                    ++temp;
                }
                if (poll.right != null) {
                    arrayDeque.add(poll.right);
                    ++temp;
                }
            }
            count = temp;
            temp = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        S199 s199 = new S199();
        TreeNode node = TreeNode.buildTreeNodeBySpecialArray(new Integer[]{1, 2, 3, null, 5, null, 4, 3, 6});
        System.out.println(node);
        for (Integer i : s199.rightSideView(node)) {
            System.out.print(i + " ");
        }
    }
}

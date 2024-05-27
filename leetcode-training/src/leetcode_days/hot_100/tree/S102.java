package leetcode_days.hot_100.tree;

import leetcode_days.data_struct.TreeNode;

import java.util.*;

// 102. 二叉树的层序遍历
public class S102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int count = 1;
        int next = 0;
        List<List<Integer>> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>(count);
            res.add(temp);
            while (count > 0) {
                TreeNode poll = queue.poll();
                assert poll != null;
                temp.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                    ++next;
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                    ++next;
                }
                --count;
            }
            count = next;
            next = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        S102 s102 = new S102();
        TreeNode node = TreeNode.buildTreeNodeBySpecialArray(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(node);
        for (List<Integer> integers : s102.levelOrder(node)) {
            for (Integer i : integers) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

package leetcode_days.hot_100.tree;

import leetcode_days.data_struct.TreeNode;

import java.util.*;

public class S473 {
    int res;
    HashMap<TreeNode, List<Long>> map = new HashMap<>();

    public void processNode(TreeNode node, int targetSum) {
        List<Long> list = new ArrayList<>();
        if (node.val == targetSum) {
            ++res;
        }
        list.add((long) node.val);
        long temp;
        if (node.left != null && map.containsKey(node.left)) {
            List<Long> integers = map.get(node.left);
            for (Long integer : integers) {
                temp = integer + node.val;
                if (temp == targetSum) {
                    ++res;
                }
                list.add(temp);
            }
        }
        if (node.right != null && map.containsKey(node.right)) {
            List<Long> integers = map.get(node.right);
            for (Long integer : integers) {
                temp = integer + node.val;
                if (temp == targetSum) {
                    ++res;
                }
                list.add(temp);
            }
        }
        map.put(node, list);
    }

    public void orderNode(TreeNode node, int targetSum) {
        if (node.left != null) {
            orderNode(node.left, targetSum);
        }
        if (node.right != null) {
            orderNode(node.right, targetSum);
        }
        processNode(node, targetSum);
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        orderNode(root, targetSum);
        return res;
    }

    public static void main(String[] args) {
        S473 s473 = new S473();
//        TreeNode node = TreeNode.buildTreeNodeBySpecialArray(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
//        TreeNode node = TreeNode.buildTreeNodeBySpecialArray(new Integer[]{1, null, 2, null, 3, null, 4, null, 5});
        TreeNode node = TreeNode.buildTreeNodeBySpecialArray(new Integer[]{1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000});
        System.out.println(node);
        System.out.println(s473.pathSum(node, 3));
    }
}

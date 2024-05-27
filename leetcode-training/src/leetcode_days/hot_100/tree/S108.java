package leetcode_days.hot_100.tree;

import leetcode_days.data_struct.TreeNode;

//108. 将有序数组转换为二叉搜索树
public class S108 {
    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left<=right){
            int len = (left + right) / 2;
            return new TreeNode(nums[len], sortedArrayToBST(nums, left, len - 1), sortedArrayToBST(nums, len + 1, right));
        }
        return null;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        S108 s108 = new S108();
        System.out.println(s108.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }
}

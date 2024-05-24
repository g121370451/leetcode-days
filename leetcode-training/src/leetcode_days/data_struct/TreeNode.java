package leetcode_days.data_struct;


import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    private Integer high;

    int getHigh() {
        if (high != null) {
            return high;
        }
        int leftHight = 0;
        int rightHight = 0;
        if (this.left != null) {
            leftHight = this.left.getHigh();
        }
        if (this.right != null) {
            rightHight = this.right.getHigh();
        }
        high = Math.max(leftHight, rightHight) + 1;
        return high;
    }

    private boolean isLastInRow;

    void setLastInRow(boolean lastInRow) {
        isLastInRow = lastInRow;
    }


    boolean isLastInRow() {
        return isLastInRow;
    }

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }


    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTreeNodeBySpecialArray(Integer[] nums) {
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        TreeNode treeNode = new TreeNode(nums[0]);
        TreeNode index = treeNode;
        boolean isleft = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != null) {
                TreeNode node = new TreeNode(nums[i]);
                if (isleft) {
                    index.left = node;
                } else {
                    index.right = node;
                }
                deque.addFirst(node);
            }
            if (!isleft) {
                index = deque.pollLast();
            }
            isleft = !isleft;
        }
        return treeNode;
    }


    private void addEmptyStringToSB(StringBuilder sb, int length) {
        sb.append(" ".repeat(Math.max(0, length)));
    }
    //TODO 完善树的输出
//    @Override
//    public String toString() {
//
//    }
}

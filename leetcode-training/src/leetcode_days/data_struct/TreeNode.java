package leetcode_days.data_struct;


import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNode {

    private static class Pair {
        public int position;
        public String key;

        public Pair(int position, String key) {
            this.position = position;
            this.key = key;
        }
    }

    public int val;
    public TreeNode left;
    public TreeNode right;

    private int position;

    int getHigh() {
        int leftHight = 0;
        int rightHight = 0;
        if (this.left != null) {
            leftHight = this.left.getHigh();
        }
        if (this.right != null) {
            rightHight = this.right.getHigh();
        }
        return Math.max(leftHight, rightHight) + 1;
    }

    void getPosition() {
        if (this.left != null) {
            this.left.position = (this.position - 2);
            this.left.getPosition();
        }
        if (this.right != null) {
            this.right.position = (this.position + 2);
            this.right.getPosition();
        }
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
                assert index != null;
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

    @Override
    public String toString() {
        // 处理一下当前的层数
        int high = this.getHigh();
        this.position = (high - 1) * 2;
        this.getPosition();
        Queue<TreeNode> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(this);
        StringBuilder stringBuilder = new StringBuilder();
        // 层次遍
        return treeToString(stringBuilder, arrayDeque);
    }

    private String treeToString(StringBuilder stringBuilder, Queue<TreeNode> arrayDeque) {
        Queue<Pair> keyQueue = new ArrayDeque<>();
        int count = 1;
        int size;
        int index;
        while (!arrayDeque.isEmpty()) {
            index = 0;
            size = 0;
            while (count > 0) {
                TreeNode poll = arrayDeque.poll();
                assert poll != null;
                int temp_index = poll.position;
                while (index++ < temp_index) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append(poll.val);
                --count;
                if (poll.left != null) {
                    arrayDeque.add(poll.left);
                    keyQueue.add(new Pair(poll.position - 1, "/"));
                    ++size;
                }
                if (poll.right != null) {
                    arrayDeque.add(poll.right);
                    keyQueue.add(new Pair(poll.position + 1, "\\"));
                    ++size;
                }
            }
            stringBuilder.append("\n");
            count = size;
            index = 0;
            while (!keyQueue.isEmpty()) {
                Pair poll = keyQueue.poll();
                while (index++ < poll.position) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append(poll.key);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}

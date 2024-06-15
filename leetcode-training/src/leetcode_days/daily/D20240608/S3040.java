package leetcode_days.daily.D20240608;

import java.util.Arrays;

public class S3040 {

    int[][] marks;

    private void dfs(int[] nums, int left, int right, int target) {
        if (left >= right) {
            return;
        }
        if (nums[left] + nums[left + 1] == target) {
            if (left + 2 < right) {
                if (marks[left + 2][right] == -1) {
                    dfs(nums, left + 2, right, target);
                }
                marks[left][right] = Math.max(marks[left][right], marks[left + 2][right] + 1);
            } else {
                marks[left][right] = 1;
            }
        }
        if (nums[left] + nums[right] == target) {
            if (left + 1 < right - 1) {
                if (marks[left + 1][right - 1] == -1) {
                    dfs(nums, left + 1, right - 1, target);
                }
            } else {
                marks[left][right] = Math.max(marks[left][right], marks[left + 1][right - 1] + 1);
            }
        }
        if (nums[right - 1] + nums[right] == target) {
            if (left < right - 2) {
                if (marks[left][right - 2] == -1) {
                    dfs(nums, left, right - 2, target);
                }
            } else {
                marks[left][right] = Math.max(marks[left][right], marks[left][right - 2] + 1);
            }
        }
        if (marks[left][right] == -1) {
            marks[left][right] = 0;
        }
    }

    private int maxOperations(int[] nums, int right, int target) {
        for (int[] row : marks) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        dfs(nums, 0, right, target);
        return marks[0][right];
    }

    public int maxOperations(int[] nums) {
        int temp = 0;
        int len = nums.length;
        marks = new int[len][len];
        temp = Math.max(maxOperations(nums, len - 1, nums[0] + nums[1]), temp);
        temp = Math.max(maxOperations(nums, len - 1, nums[0] + nums[len - 1]), temp);
        temp = Math.max(maxOperations(nums, len - 1, nums[len - 1] + nums[len - 2]), temp);
        return temp;
    }

    public static void main(String[] args) {
        S3040 s3040 = new S3040();
        int[] nums = {3, 2, 1, 2, 3, 4};
//        int[] nums = {1, 9, 7, 3, 2, 7, 4, 12, 2, 6};
        System.out.println(s3040.maxOperations(nums));
    }
}

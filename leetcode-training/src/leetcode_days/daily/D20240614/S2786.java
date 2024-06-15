package leetcode_days.daily.D20240614;

import java.util.Arrays;

// 2786. 访问数组中的位置使分数最大
public class S2786 {
    long[][] mark;
    int len;

    private long getScore(int[] nums, int start, int x, int j) {
        if (mark[start][j] != -1L) {
            return mark[start][j];
        }
        if (len == start + 1) {
            mark[start][nums[start] % 2] = nums[start];
            mark[start][(nums[start] - 1) % 2] = nums[start] - x > 0 ? nums[start] - x : 0L;
            return mark[start][j];
        }
        int t = nums[start] % 2;
        long addThis = t == j ? nums[start] : nums[start] - x;
        mark[start][j] = Math.max(getScore(nums, start + 1, x, j), getScore(nums, start + 1, x, t) + addThis);
        return mark[start][j];
    }

    public long maxScore(int[] nums, int x) {
        len = nums.length;
        mark = new long[len][2];
        for (long[] longs : mark) {
            Arrays.fill(longs, -1L);
        }
        return nums[0] + getScore(nums, 1, x, nums[0] % 2);
    }

    public static void main(String[] args) {
        S2786 s2786 = new S2786();
        System.out.println(s2786.maxScore(new int[]{2, 3, 6, 1, 9, 2}, 5));
    }
}

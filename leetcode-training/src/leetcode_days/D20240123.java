package leetcode_days;

/**
 * 2765. 最长交替子数组
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 。如果 nums 中长度为 m 的子数组 s 满足以下条件，我们称它是一个 交替子数组 ：
 * <p>
 * m 大于 1 。
 * s1 = s0 + 1 。
 * 下标从 0 开始的子数组 s 与数组 [s0, s1, s0, s1,...,s(m-1) % 2] 一样。也就是说，s1 - s0 = 1 ，s2 - s1 = -1 ，s3 - s2 = 1 ，s4 - s3 = -1 ，以此类推，直到 s[m - 1] - s[m - 2] = (-1)m 。
 * 请你返回 nums 中所有 交替 子数组中，最长的长度，如果不存在交替子数组，请你返回 -1 。
 * <p>
 * 子数组是一个数组中一段连续 非空 的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,4,3,4]
 * 输出：4
 * 解释：交替子数组有 [3,4] ，[3,4,3] 和 [3,4,3,4] 。最长的子数组为 [3,4,3,4] ，长度为4 。
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6]
 * 输出：2
 * 解释：[4,5] 和 [5,6] 是仅有的两个交替子数组。它们长度都为 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 100
 * 1 <= nums[i] <= 104
 * <u>
 * <p>
 * 暴力记录位状态
 * </p>
 * </u>
 */
public class D20240123 {
    public int alternatingSubarray(int[] nums) {
        int[] status = new int[nums.length];
        int[] result = new int[nums.length];
        result[0] = 1;
        status[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            if (status[i - 1] == 0) {
                if (nums[i] == nums[i - 1] + 1) {
                    result[i] = result[i - 1] + 1;
                    status[i] = 1;
                } else {
                    result[i] = 1;
                    status[i] = 0;
                }
            }
            // 先判断加一减一
            else if ((result[i - 1] % 2 == 0) && (nums[i] == nums[i - 1] - 1)) {
                // 减一
                status[i] = 1;
                result[i] = result[i - 1] + 1;
            } else if ((result[i - 1] % 2 != 0) && nums[i] == nums[i - 1] + 1) {
                status[i] = 1;
                result[i] = result[i - 1] + 1;
            } else if (nums[i] == nums[i - 1] + 1) {
                status[i] = 1;
                result[i] = 2;
            } else {
                status[i] = 0;
                result[i] = 1;
            }
        }
        int max = result[0];
        for (int i : result) {
            if (i > max) {
                max = i;
            }
        }
        if (max == 1) {
            return -1;
        }
        return max;
    }

    public static void main(String[] args) {
        D20240123 d = new D20240123();
        int[] nums1 = {2, 3, 4, 3, 4};
        int[] nums2 = {4, 5, 6};
        System.out.println(d.alternatingSubarray(nums1));
        System.out.println(d.alternatingSubarray(nums2));
    }
}

package leetcode_days.daily.D20240615;

import java.util.Arrays;

public class S2779 {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int right = nums[0] + k;
        int leftIndex = 0;
        int res = 1;
        int temp = res;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= right + k) {
                ++temp;
                right = nums[i] + k;
                while (nums[leftIndex] < nums[i] - k * 2) {
                    --temp;
                    ++leftIndex;
                }
            } else {
                temp = 1;
                leftIndex = i;
                right = nums[i] + k;
            }
            res = Math.max(res, temp);
        }
        return res;
    }

    public static void main(String[] args) {
        S2779 s2779 = new S2779();
//        System.out.println(s2779.maximumBeauty(new int[]{4, 6, 1, 2}, 2));
        System.out.println(s2779.maximumBeauty(new int[]{50,28,30,51}, 2));
//        System.out.println(s2779.maximumBeauty(new int[]{49, 26}, 12));
    }
}

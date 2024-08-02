package leetcode_days.daily.D20240710;


public class S2970 {
    public long incremovableSubarrayCount(int[] nums) {
        int len = nums.length;
        int index = 0;
        for (; index < len - 1; index++) {
            if (nums[index] >= nums[index + 1]) {
                break;
            }
        }
        if (index == len - 1) {
            return (long) (len + 1) * len / 2;
        }
        long res = index + 2;
        int i = index;
        for (int j = len - 1; j ==len-1 || nums[j-1] < nums[j]; j--) {
            while (i >= 0 && nums[i] >= nums[j]) {
                --i;
            }
            res += (i + 2);
        }
        return res;
    }

    public static void main(String[] args) {
        S2970 s2970 = new S2970();
//        System.out.println(s2970.incremovableSubarrayCount(new int[]{6, 5, 7, 8}));
        System.out.println(s2970.incremovableSubarrayCount(new int[]{8, 7, 6, 6}));
    }
}

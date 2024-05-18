package leetcode_days.daily.D20240518;

public class S2644 {

    public int maxDivScore(int[] nums, int[] divisors) {
        int res = divisors[0];
        int count_max = 0;
        int count;
        for (int divisor : divisors) {
            count = 0;
            for (int num : nums) {
                if (divisor <= num && num % divisor == 0) {
                    ++count;
                }
            }
            if (count > count_max) {
                count_max = count;
                res = divisor;
            } else if (count == count_max && divisor < res) {
                res = divisor;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {4, 7, 9, 3, 9}, divisors = {5, 2, 3};
        int[] nums = {20, 14, 21, 10}, divisors = {5, 7, 5};
        S2644 s2644 = new S2644();
        System.out.println(s2644.maxDivScore(nums, divisors));
    }
}

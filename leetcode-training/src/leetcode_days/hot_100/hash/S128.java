package leetcode_days.hot_100.hash;

import java.util.HashSet;
import java.util.Set;

// 最长连续数
// 只对连续数字的头做判断 如果不是头则跳过 所以平均复杂度为on
public class S128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            int res_temp = 1;
            if (!set.contains(num - 1)) {
                while (set.contains(num + 1)) {
                    ++res_temp;
                    ++num;
                }
                if (res_temp > res) {
                    res = res_temp;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        S128 s128 = new S128();
        int[] nums = {100, 4, 200, 1, 3, 2};
        int i = s128.longestConsecutive(nums);
        System.out.println(i);
    }
}

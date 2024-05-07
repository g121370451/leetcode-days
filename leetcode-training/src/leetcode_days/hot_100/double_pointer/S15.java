package leetcode_days.hot_100.double_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//15. 三数之和

/**
 * 从左往右 依次枚举 变为2数之和 因为是排序后的数组 所以两数之和的复杂度是O(N) 因为N主键变小 所以是NLogN复杂度
 * 因为不重复 所以要判断是否与上一次选择的数相同 相同则直接跳过
 */
public class S15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int pre = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            if (pre == target) {
                continue;
            }
            pre = target;
            int j = i + 1, k = nums.length - 1;
            int prej = Integer.MIN_VALUE;
            int preK = Integer.MAX_VALUE;
            while (j < k) {
                if (nums[j] + nums[k] > target) {
                    k--;
                } else if (nums[j] + nums[k] < target) {
                    j++;
                } else {
                    if (prej != nums[j] && preK!= nums[k]){
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        prej = nums[j];
                        preK = nums[k];
                    }
                    k--;
                    j++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        S15 s15 = new S15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {1,-1,-1,0};
        List<List<Integer>> lists = s15.threeSum(nums);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i);
            }
            System.out.println("");
        }
    }
}

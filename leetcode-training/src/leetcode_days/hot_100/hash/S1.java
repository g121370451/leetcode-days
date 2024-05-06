package leetcode_days.hot_100.hash;

import java.util.HashMap;

// 两数之和
public class S1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                res[0] = map.get(nums[i]);
                res[1] = i;
                return res;
            }else{
                map.put(target-nums[i],i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        S1 s1 = new S1();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ints = s1.twoSum(nums, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

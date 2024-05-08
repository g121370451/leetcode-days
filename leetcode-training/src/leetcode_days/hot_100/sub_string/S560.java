package leetcode_days.hot_100.sub_string;

import java.util.HashMap;
import java.util.Map;

// 和为k的子数组
// 1, 1, 1 // 2
// 3 2 1
// 2 + 3-1
// 可以
public class S560 {
    public int subarraySumTLE(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> indexMapSum = new HashMap<>(nums.length);
        int indexStart = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            indexMapSum.put(i, sum);
        }
        int sub = 0;
        while (indexStart < nums.length) {
            for (Map.Entry<Integer, Integer> entry : indexMapSum.entrySet()) {
                entry.setValue(entry.getValue() - sub);
                if (entry.getValue() == k) {
                    ++res;
                }
            }
            sub = nums[indexStart];
            indexMapSum.remove(indexStart++);
        }
        return res;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int partition = getPartition(nums, left, right);
            quickSort(nums, left, partition - 1);
            quickSort(nums, partition + 1, right);
        }
    }

    private int getPartition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] > pivot) --right;
            if (left < right) nums[left++] = nums[right];
            while (left < right && nums[left] < pivot) ++left;
            if (left < right) nums[right--] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int[] sums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
        map.put(0, 1);// 为空的0置为1
        // 两数之差
        for (int j : sums) {
            if (map.containsKey(j - k)) {
                res += map.get(j - k);
            }
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
        int[] nums = {1, 1,1};
        int k = 2;
        S560 s560 = new S560();
        int i = s560.subarraySum(nums, k);
        System.out.println(i);
    }
}

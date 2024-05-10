package leetcode_days.hot_100.arrays;

// start=0;
//41. 缺失的第一个正数
// 9, 7, 5, 3, 1, 2, 4, 0 ->
// 5, 3, 1, 2, 4, 0 ->
// 2 3 2 1 -> 1 2 1
// 题目要求是常数级 可以看做提示 要对数组本身做修改
// 因为是从1开始的连续数字 所以可以用交换数字到数组的index保存他是否存在 不存在就是-1 问题变为找第一个-1
public class S41 {

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (i != num - 1) {
                if (num > 0 && num <= len && nums[num - 1] != num) {
                    temp = nums[num - 1];
                    nums[num - 1] = num;
                    nums[i] = temp;
                    --i;
                } else {
                    nums[i] = -1;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        S41 s41 = new S41();
        int[] nums = {9, 7, 5, 3, 1, 2, 4, 0};//6
        int i = s41.firstMissingPositive(nums);
        System.out.println(i);
    }

}

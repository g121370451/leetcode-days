package leetcode_days.hot_100.double_pointer;

// 移动0
public class S283 {

    public void moveZeroes(int[] nums) {
        // 统计非零元素 再把0添加进数组
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
            ++j;
        }
        while(i<nums.length){
            nums[i++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        S283 s283 = new S283();
        s283.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num);
        }
    }
}
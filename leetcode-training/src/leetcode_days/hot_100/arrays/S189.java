package leetcode_days.hot_100.arrays;

//189. 轮转数组
// 1.原地反转数组
public class S189 {
    public void reverse(int[] nums, int left, int right) {
        int temp;
        while (left < right) {
            temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void main(String[] args) {
        S189 s189 = new S189();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        s189.rotate(nums, 3);
        for (int num : nums) {
            System.out.print(num + "");
        }
    }
}

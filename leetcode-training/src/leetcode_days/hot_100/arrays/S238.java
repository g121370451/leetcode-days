package leetcode_days.hot_100.arrays;

//238. 除自身以外数组的乘积
public class S238 {

    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] after = new int[nums.length];
        pre[0] = 1;
        after[nums.length - 1] = 1;
        int i = 1, j = nums.length - i - 1;
        while (i < nums.length) {
            pre[i] = pre[i - 1] * nums[i - 1];
            if (pre[i] == 0) {
                break;
            }
            i++;
        }
        while (j >= 0) {
            after[j] = after[j + 1] * nums[j + 1];
            if (after[j] == 0) {
                break;
            }
            j--;
        }
        int[] res = new int[nums.length];
        for (int k = 0; k < nums.length; k++) {
            res[k] = pre[k] * after[k];
        }
        return res;
    }

    public static void main(String[] args) {
        S238 s238 = new S238();
        int[] nums = {1, 2, 3, 4};
        int[] ints = s238.productExceptSelf(nums);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}

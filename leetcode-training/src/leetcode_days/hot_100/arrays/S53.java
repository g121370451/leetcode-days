package leetcode_days.hot_100.arrays;

//53. 最大子数组和
// 因为是连续的子数组 所以要判断是否值得为了加正数而忍受负数的进入
// 1.我是通过temp重新置0来保证不加负数
// 2.pre=Math.max(pre+nums[i],nums[i]);
//   max=Math.max(pre,max);
//   通过pre来保存非负数的前置最大值 如果当前比加前置最大值还大（就是前置是负数 res_temp<0）则只保留自己（res_temp=0)
public class S53 {
    public int maxSubArray(int[] nums) {
        int res_temp = 0;
        int res = -100001;
        for (int num : nums) {
            res_temp += num;
            res = Math.max(res, res_temp);
            if (res_temp < 0) {
                res_temp = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        S53 s53 = new S53();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = s53.maxSubArray(nums);
        System.out.println(i);
    }
}

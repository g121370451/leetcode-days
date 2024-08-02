package leetcode_days.weekly.W20240623;

public class S100337 {
    public long maximumTotalCost(int[] nums) {
        // 记录每个数字 取正取负的最大值
        int len = nums.length;
        int[][] mark = new int[len][2];
        mark[len-1][0] = nums[len-1];
        mark[len-1][1] = -nums[len-1];
        for(int i = len-2;i>=0;i--){
            mark[i][0] = Math.max(nums[i] + mark[i+1][0],nums[i]+mark[i+1][1]);
            mark[i][1] = -nums[i] + mark[i+1][0];
        }
        return mark[0][0];
    }

    public static void main(String[] args) {
        S100337 s100337 = new S100337();
//        System.out.println(s100337.maximumTotalCost(new int[]{1, -2, 3, 4}));
        System.out.println(s100337.maximumTotalCost(new int[]{-14,-13,-20}));
    }
}

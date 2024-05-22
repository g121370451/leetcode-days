package leetcode_days.weekly.W20240519;

public class S100310 {
    public boolean isArraySpecial(int[] nums) {
        int flag = nums[0] % 2;
        int flag_temp;
        boolean res = true;
        for (int i = 1;i<nums.length;i++){
            flag_temp = nums[i] % 2;
            if (flag_temp!=flag){
                flag = flag_temp;
            }else{
                res = false;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        S100310 s100310 = new S100310();
        int[] nums = {2, 1, 4};
        System.out.println(s100310.isArraySpecial(nums));
    }
}

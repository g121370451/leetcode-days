package leetcode_days.daily.D20240525;

public class S2903 {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int[] res = {-1, -1};
        for (int i = 0; i + indexDifference < nums.length; i++) {
            for (int j = i + indexDifference; j < nums.length; j++) {
                if (Math.abs(nums[j] - nums[i]) >= valueDifference) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        S2903 s2903 = new S2903();
        int[] nums = {5, 1, 4, 1};
        int k = 2, j = 4;
        for (int index : s2903.findIndices(nums, k, j)) {
            System.out.println(index);
        }
    }
}

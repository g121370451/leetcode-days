package leetcode_days.weekly.W20240623;

import java.util.Arrays;

public class S100342 {
    public double minimumAverage(int[] nums) {
        int left = 0, right = nums.length - 1;
        Arrays.sort(nums);
        int len = nums.length;
        int step = len / 2;
        double[] average = new double[step];
        double temp = (double) (nums[left++] + nums[right--]) / 2;
        average[0] = temp;
        step--;
        while (step > 0) {
            temp = (double) (nums[left++] + nums[right--]) / 2;
            int temp_index = average.length-step;
            while (temp_index >= 1 && average[temp_index-1] > temp) {
                average[temp_index] = average[temp_index-1];
                temp_index--;
            }
            average[temp_index] = temp;
            step--;
        }
        return average[0];
    }

    public static void main(String[] args) {
        S100342 s100342 = new S100342();
        System.out.println(s100342.minimumAverage(new int[]{7, 8, 3, 4, 15, 13, 4, 1}));
    }
}

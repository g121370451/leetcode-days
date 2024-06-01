package leetcode_days.weekly.W20240526;

import java.util.Arrays;

public class S100321 {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        long res = 0L;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // i的可以从j开始的坐标
        int[] j_start = new int[nums1.length];
        // i的前一个i
        int[] pre = new int[nums1.length];
        Arrays.fill(pre, -1);
        int[] mark = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums1[i] % nums1[j] == 0) {
                    pre[i] = j;
                    break;
                }
            }
        }
        int count;
        int j;
        int index;
        for (int i = 0; i < nums1.length; i++) {
            if (pre[i] == -1){
                count = 0;
                index = 0;
            }else{
                count = mark[pre[i]];
                index = j_start[pre[i]];
            }
            for (j = index; j < nums2.length && nums1[i] >= nums2[j] * k; j++) {
                if (nums1[i] % (nums2[j] * k) == 0) {
                    ++count;
                    index = j + 1;
                }
            }
            j_start[i] = index;
            mark[i] = count;
            res += count;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 4, 12};
//        int[] nums1 = {12, 4};
//        int[] nums2 = {1, 4};
//        int[] nums2 = {2, 4};
//        int[] nums1 = {28, 42};
//        int[] nums2 = {6, 4};
        int[] nums1 = {4,60,120};
        int[] nums2 = {10,20,4};

        S100321 s100321 = new S100321();
        System.out.println(s100321.numberOfPairs(nums1, nums2, 6));
    }
}

package leetcode_days.daily.D20240716;

import java.util.HashMap;
import java.util.Map;

public class S2956 {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i : nums1) {
            map1.put(i, 1);
        }
        for (int i : nums2) {
            map2.put(i, 1);
        }
        int[] res = new int[2];
        for (int j = nums1.length - 1; j >= 0; j--) {
            if (map2.containsKey(nums1[j])) {
                ++res[0];
            }
        }
        for (int j = nums2.length - 1; j >= 0; j--) {
            if (map1.containsKey(nums2[j])) {
                ++res[1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        S2956 s2956 = new S2956();
        for (int intersectionValue : s2956.findIntersectionValues(new int[]{4, 3, 2, 3, 1}, new int[]{2, 2, 5, 2, 3, 6})) {
            System.out.println(intersectionValue);
        }
    }
}

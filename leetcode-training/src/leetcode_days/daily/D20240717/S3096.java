package leetcode_days.daily.D20240717;

import java.util.Arrays;

public class S3096 {
    public int minimumLevels(int[] possible) {
        int[] mark = new int[possible.length];
        int n = possible.length;
        mark[n - 1] = possible[n - 1] == 0 ? -1 : 1;
        for (int i = n - 2; i >= 0; i--) {
            mark[i] = mark[i + 1] + (possible[i] == 0 ? -1 : 1);
        }
        int sumPre = 0;
        for (int i = 0; i < n - 1; i++) {
            if (possible[i] == 0) {
                sumPre--;
            } else {
                sumPre++;
            }
            if (sumPre > mark[i + 1]) {
                return i + 1;
            }
        }
        return -1;
    }
}

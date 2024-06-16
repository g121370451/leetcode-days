package leetcode_days.weekly.W20240616;

import java.util.Arrays;

public class S100316 {
    long[] mark;

    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        mark = new long[power.length];
        Arrays.fill(mark, -1L);
        return maximun(power, 0);
    }

    public long maximun(int[] power, int leftIndex) {
        if (leftIndex >= power.length) {
            return 0L;
        }
        if (mark[leftIndex] != -1) {
            return mark[leftIndex];
        }
        // 拿头和不拿头
        int temp = power[leftIndex];
        int head = 0;
        int index_temp = leftIndex;
        int index_next = leftIndex;
        while (index_temp < power.length && power[index_temp] <= temp + 2) {
            if (power[index_next] == temp) {
                head += temp;
                index_next++;
            }
            index_temp++;
        }
        mark[leftIndex] = Math.max(head + maximun(power, index_temp), maximun(power, index_next));
        return mark[leftIndex];
    }


    public static void main(String[] args) {
        S100316 s100316 = new S100316();
        System.out.println(s100316.maximumTotalDamage(new int[]{}));
    }
}

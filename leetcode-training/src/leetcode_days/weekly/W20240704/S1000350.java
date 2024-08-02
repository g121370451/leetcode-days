package leetcode_days.weekly.W20240704;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S1000350 {
    public int minimumCost(String target, String[] words, int[] costs) {
        int m = words.length;
        int n = target.length();

        // Initialize dp array
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = 0;

        for (int i = 1; i <= m; i++) {
            String word = words[i - 1];
            int cost = costs[i - 1];
            int wordLen = word.length();
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j >= wordLen && dp[i - 1][j - wordLen] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - wordLen] + cost);
                }
            }
        }

        int result = dp[m][n];
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        S1000350 s1000350 = new S1000350();
        System.out.println(s1000350.minimumCost("abcdef", new String[]{"abdef", "abc", "d", "def", "ef"}, new int[]{100, 1, 1, 10, 5}));
    }
}

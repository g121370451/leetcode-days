package leetcode_days.daily.D20240628;

import java.util.Arrays;

public class S2742 {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[][] memo = new int[n][n * 2 + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        return dfs(n - 1, 0, cost, time, memo);
    }

    private int dfs(int i, int j, int[] cost, int[] time, int[][] memo) {
        if (j > i) { // 剩余的墙都可以免费刷
            return 0;
        }
        if (i < 0) { // 上面 if 不成立，意味着 j < 0，不符合题目要求
            return Integer.MAX_VALUE / 2; // 防止加法溢出
        }
        int k = j + memo.length; // 加上偏移量，防止出现负数
        if (memo[i][k] != -1) { // 之前计算过
            return memo[i][k];
        }
        int res1 = dfs(i - 1, j + time[i], cost, time, memo) + cost[i];
        int res2 = dfs(i - 1, j - 1, cost, time, memo);
        return memo[i][k] = Math.min(res1, res2);
    }

    public static void main(String[] args) {
        S2742 s2742 = new S2742();
        System.out.println(s2742.paintWalls(new int[]{1, 2, 2, 2}, new int[]{1, 2, 3, 2}));
    }
}

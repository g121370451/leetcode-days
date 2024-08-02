package leetcode_days.daily.D20240721;

import java.util.Arrays;

public class S1186 {
    private int[] arr;
    private int[][] memo;

    public int maximumSum(int[] arr) {
        this.arr = arr;
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        memo = new int[n][2];
        for (int[] row : memo)
            Arrays.fill(row, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++)
            ans = Math.max(ans, Math.max(dfs(i, 0), dfs(i, 1)));
        return ans;
    }

    private int dfs(int i, int j) {
        if (i < 0)
            return Integer.MIN_VALUE / 2; // 除 2 防止负数相加溢出
        if (memo[i][j] != Integer.MIN_VALUE)
            return memo[i][j]; // 之前计算过
        if (j == 0)
            return memo[i][j] = Math.max(dfs(i - 1, 0), 0) + arr[i];
        return memo[i][j] = Math.max(dfs(i - 1, 1) + arr[i], dfs(i - 1, 0));
    }

    public static void main(String[] args) {
        S1186 s1186 = new S1186();
        System.out.println(s1186.maximumSum(new int[]{1, -2, 0, 3}));
    }
}

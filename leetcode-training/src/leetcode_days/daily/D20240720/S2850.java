package leetcode_days.daily.D20240720;

import java.util.*;

public class S2850 {
    List<List<Integer>> from;
    List<List<Integer>> to;
    int res;

    public int minimumMoves(int[][] grid) {
        res = Integer.MAX_VALUE;
        from = new ArrayList<>();
        to = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] > 1) {
                    from.add(Arrays.asList(i, j, grid[i][j] - 1));
                } else if (grid[i][j] == 0) {
                    to.add(Arrays.asList(i, j));
                }
            }
        }
        dfs(0, 0);
        return res;
    }

    private void dfs(int index, int resTemp) {
        if (index == to.size()) {
            res = Math.min(res, resTemp);
            return;
        }
        List<Integer> toP = to.get(index);
        for (int i = 0; i < from.size(); i++) {
            List<Integer> fromP = from.get(i);
            if (fromP.get(2) > 0) {
                fromP.set(2, fromP.get(2) - 1);
                dfs(index + 1, resTemp + Math.abs(fromP.get(0) - toP.get(0)) + Math.abs(fromP.get(1) - toP.get(1)));
                fromP.set(2, fromP.get(2) + 1);
            }
        }
    }


    public static void main(String[] args) {
        S2850 s2850 = new S2850();
//        System.out.println(s2850.minimumMoves(new int[][]{{1, 3, 0}, {1, 0, 0}, {1, 0, 3}}));
        System.out.println(s2850.minimumMoves(new int[][]{{1, 2, 2}, {1, 1, 0}, {0, 1, 1}}));
        // 1 2 2
        // 1 1 0
        // 0 1 1
    }
}

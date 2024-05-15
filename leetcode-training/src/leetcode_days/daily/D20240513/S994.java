package leetcode_days.daily.D20240513;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class S994 {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = -1;
                } else if (grid[i][j] == 2) {
                    deque.add(i);
                    deque.add(j);
                }
            }
        }
        int time = 0;
        int size = deque.size() / 2;
        int i;
        int j;
        while (!deque.isEmpty()) {
            while (size > 0) {
                i = deque.poll();
                j = deque.poll();
                grid[i][j] = time;
                if (i + 1 < m && grid[i + 1][j] == -1) {
                    deque.add(i + 1);
                    deque.add(j);
                    grid[i + 1][j] = 0;
                }
                if (i - 1 >= 0 && grid[i - 1][j] == -1) {
                    deque.add(i - 1);
                    deque.add(j);
                    grid[i - 1][j] = 0;
                }
                if (j - 1 >= 0 && grid[i][j - 1] == -1) {
                    deque.add(i);
                    deque.add(j - 1);
                    grid[i][j - 1] = 0;
                }
                if (j + 1 < n && grid[i][j + 1] == -1) {
                    deque.add(i);
                    deque.add(j + 1);
                    grid[i][j + 1] = 0;
                }
                --size;
            }
            ++time;
            size = deque.size() / 2;
        }
        int res = 0;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == -1) {
                    return -1;
                } else if (grid[i][j] > 0) {
                    res = Math.max(res, grid[i][j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        S994 s994 = new S994();
//        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int[][] grid = {{2, 2}, {1, 1}, {0, 0}, {2, 0}};
//        int[][] grid = {{0}};
        System.out.println(s994.orangesRotting(grid));
    }
}

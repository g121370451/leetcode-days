package leetcode_days.daily.D20240515;

import java.util.*;

//2589. 完成所有任务的最少时间
public class S2589 {
    public int findMinimumTimeBruteForceAlgorithm(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[1]));
        int[] marks = new int[tasks[tasks.length - 1][1] + 1];
        for (int[] task : tasks) {
            for (int i = task[0]; i <= task[1]; i++) {
                if (task[1] - i + 1 == task[2]) {
                    marks[i] = 1;
                }
                if (marks[i] == 1) {
                    --task[2];
                }
            }
        }
        int res = 0;
        for (int mark : marks) {
            res += mark;
        }
        return res;
    }

    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[1]));
        int[] marks = new int[tasks[tasks.length - 1][1] + 1];
        for (int[] task : tasks) {
            for (int i = task[0]; i <= task[1]; i++) {
                if (task[1] - i + 1 == task[2]) {
                    marks[i] = 1;
                }
                if (marks[i] == 1) {
                    --task[2];
                }
            }
        }
        int res = 0;
        for (int mark : marks) {
            res += mark;
        }
        return res;
    }

    public static void main(String[] args) {
        S2589 s2589 = new S2589();
        int[][] tasks = {{2, 3, 1}, {4, 5, 1}, {1, 5, 2}};//2
        int minimumTime = s2589.findMinimumTime(tasks);
        System.out.println(minimumTime);
    }
}

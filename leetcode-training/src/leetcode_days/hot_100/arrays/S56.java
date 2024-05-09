package leetcode_days.hot_100.arrays;

import java.util.*;

//56. 合并区间
// 官方的答案是排序
// 不排序的解法
public class S56 {
    private void quickSort(int[][] intervals, int left, int right) {
        if (left < right) {
            int partition = getPartition(intervals, left, right);
            quickSort(intervals, left, partition - 1);
            quickSort(intervals, partition + 1, right);
        }
    }

    private int getPartition(int[][] intervals, int left, int right) {
        int[] pivot = intervals[left];
        while (left < right) {
            while (left < right && intervals[right][0] > pivot[0]) --right;
            if (left < right) intervals[left++] = intervals[right];
            while (left < right && intervals[left][0] < pivot[0]) ++left;
            if (left < right) intervals[right--] = intervals[left];
        }
        intervals[left] = pivot;
        return left;
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        quickSort(intervals, 0, intervals.length - 1);
        List<int[]> merged = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            int L = interval[0], R = interval[1];
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public int[][] mergeNoSort(int[][] intervals) {
        //TODO 有不需要排序的解法 空间换时间
        return null;
    }

    public static void main(String[] args) {
        S56 s56 = new S56();

//        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
//        int[][] intervals = {{1, 4}, {1, 5}};
//        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] merge = s56.merge(intervals);
        for (int i = 0; i < merge.length; i++) {
            for (int j = 0; j < merge[i].length; j++) {
                System.out.print(merge[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

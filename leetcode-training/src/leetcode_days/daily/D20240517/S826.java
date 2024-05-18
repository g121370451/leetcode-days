package leetcode_days.daily.D20240517;

import java.util.Arrays;
import java.util.Comparator;

public class S826 {

    private void quickSort(int[] profit, int[] difficulty, int left, int right) {
        if (left < right) {
            int partition = getPartition(profit, difficulty, left, right);
            quickSort(profit, difficulty, left, partition - 1);
            quickSort(profit, difficulty, partition + 1, right);
        }
    }

    private int getPartition(int[] profit, int[] difficulty, int left, int right) {
        int pivot = profit[left];
        int pivotD = difficulty[left];
        while (left < right) {
            while (left < right && profit[right] > pivot) right--;
            if (left < right) {
                profit[left] = profit[right];
                difficulty[left++] = difficulty[right];
            }
            while (left < right && profit[left] < pivot) left++;
            if (left < right) {
                profit[right] = profit[left];
                difficulty[right--] = difficulty[left];
            }
        }
        profit[left] = pivot;
        difficulty[left] = pivotD;
        return left;
    }

    // 只保存小余等于的
    private int findFistIndex(int[] difficulty, int target) {
        for (int i = difficulty.length - 1; i >= 0; i--) {
            if (target >= difficulty[i]) {
                return i;
            }
        }
        return -1;
    }

    public int maxProfitAssignmentOlder(int[] difficulty, int[] profit, int[] worker) {
        int res = 0;
        quickSort(profit, difficulty, 0, profit.length - 1);
        for (int i : worker) {
            int fistIndex = findFistIndex(difficulty, i);
            if (fistIndex != -1) {
                res += profit[fistIndex];
            }
        }
        return res;
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int res = 0;
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        int max = 0;
        for (int[] job : jobs) {
            if (max < job[1]){
                max = job[1];
            }
            job[1] = max;
        }
        Arrays.sort(worker);
        int index = profit.length - 1;
        for (int i = worker.length - 1; i >= 0; i--) {
            while (index >= 0 && worker[i] < jobs[index][0]) {
                --index;
            }
            if (index >= 0) {
                res += jobs[index][1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        S826 s826 = new S826();
        int[] difficulty = {5, 50, 92, 21, 24, 70, 17, 63, 30, 53};
        int[] profit = {68, 100, 3, 99, 56, 43, 26, 93, 55, 25};
        int[] worker = {96, 3, 55, 30, 11, 58, 68, 36, 26, 1};
        System.out.println(s826.maxProfitAssignment(difficulty, profit, worker));
    }
}

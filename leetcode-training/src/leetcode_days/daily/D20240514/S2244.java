package leetcode_days.daily.D20240514;

import java.util.HashMap;
import java.util.Map;

//2244. 完成所有任务需要的最少轮数
public class S2244 {

    // 排序算法
    private void quickSort(int[] tasks, int left, int right) {
        if (left < right) {
            int partition = getPartition(tasks, left, right);
            quickSort(tasks, left, partition - 1);
            quickSort(tasks, partition + 1, right);
        }
    }

    private int getPartition(int[] tasks, int left, int right) {
        int pivot = tasks[left];
        while (left < right) {
            while (left < right && tasks[right] > pivot) --right;
            if (left < right) tasks[left++] = tasks[right];
            while (left < right && tasks[left] < pivot) ++left;
            if (left < right) tasks[right--] = tasks[left];
        }
        tasks[left] = pivot;
        return left;
    }
    public int minimumRoundsOrder(int[] tasks) {
        quickSort(tasks, 0, tasks.length - 1);
        int res = 0;
        int pre = 0;
        int[] target = {0, -1, 1, 1, 2};
        int sum = 0;
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] == pre) {
                ++sum;
                if (sum > 4) {
                    sum -= 3;
                    ++res;
                }
            } else {
                if (target[sum] == -1) {
                    return -1;
                }
                res += target[sum];
                sum = 1;
                pre = tasks[i];
            }
        }
        if (target[sum] == -1) {
            return -1;
        }
        res += target[sum];
        return res;
    }

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int[] target = {0, -1, 1, 1, 2};
        int pivot;
        int sum;
        for (int task : tasks) {
            pivot = task;
            sum = map.getOrDefault(pivot, 0) + 1;
            if (sum > 4) {
                sum -= 3;
                ++res;
            }
            map.put(pivot, sum);
        }
        for (Integer value : map.values()) {
            if (target[value] == -1) {
                return -1;
            } else {
                res += target[value];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        S2244 s2244 = new S2244();
        int[] tasks = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
        System.out.println(s2244.minimumRounds(tasks));
    }
}

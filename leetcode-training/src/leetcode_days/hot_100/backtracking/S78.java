package leetcode_days.hot_100.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S78 {
    /** 我的不好的代码
    private int len;
    private int[] nums;
    private List<Integer> path;
    private boolean[] isUsed;
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        len = nums.length;
        this.nums = nums;
        path = Arrays.asList(new Integer[len]);
        isUsed = new boolean[len];
        res.add(new ArrayList<>());
        build(0);
        return res;
    }

    private void build(int n) {
        if (n == len) {
            return;
        }
        isUsed[n] = true;
        path.set(0, nums[n]);
        int length = 1;
        res.add(new ArrayList<>(path.subList(0, length)));
        for (int i = n + 1; i < len; i++) {
            dfs(length, i);
        }
        build(n + 1);
    }

    private void dfs(int length, int start) {
        isUsed[start] = true;
        path.set(length, nums[start]);
        res.add(new ArrayList<>(path.subList(0, length+1)));
        for (int i = start + 1; i < len; i++) {
            dfs(length+1, i);
        }
        isUsed[start] = false;
    }
    **/
    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        ans.add(new ArrayList<>(path)); // 复制 path
        for (int j = i; j < nums.length; ++j) { // 枚举选择的数字
            path.add(nums[j]);
            dfs(j + 1);
            path.remove(path.size() - 1); // 恢复现场
        }
    }
    public static void main(String[] args) {
        S78 s78 = new S78();
//        for (List<Integer> integers : s78.subsets(new int[]{1, 2, 3})) {
//            for (Integer integer : integers) {
//                System.out.print(integer+",");
//            }
//            System.out.println(" ");
//        }
        for (List<Integer> integers : s78.subsets(new int[]{3, 2, 4, 1})) {
            for (Integer integer : integers) {
                System.out.print(integer + ",");
            }
            System.out.println(" ");
        }
    }
}

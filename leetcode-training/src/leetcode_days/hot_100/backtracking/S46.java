package leetcode_days.hot_100.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class S46 {
    List<Integer> path;
    boolean[] isUsed;
    int[] nums;
    int len;
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        res = new ArrayList<>();
        len = nums.length;
        path = Arrays.asList(new Integer[len]);
        isUsed = new boolean[nums.length];
        dfs(0);
        return res;
    }
    private void dfs(int index){
        if(index == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<len;i++){
            if(!isUsed[i]){
                path.set(index,nums[i]);
                isUsed[i] = true;
                dfs(index+1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        S46 s46 = new S46();
        for (List<Integer> integers : s46.permute(new int[]{1, 2, 3})) {
            for (Integer integer : integers) {
                System.out.print(integer+",");
            }
            System.out.println(" ");
        }
    }
}

package leetcode_days.daily.D20240522;

import java.util.*;

public class S2225 {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res = new ArrayList<>(2);
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {
            map.put(match[0], map.getOrDefault(match[0], 0));
            map.put(match[1], map.getOrDefault(match[1], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()==0){
                res1.add(entry.getKey());
            }
            else if (entry.getValue() == 1){
                res2.add(entry.getKey());
            }
        }
        res.add(res1);
        Collections.sort(res1);
        Collections.sort(res2);
        res.add(res2);
        return res;
    }

    public static void main(String[] args) {
        S2225 s2225 = new S2225();
        int[][] nums = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        List<List<Integer>> winners = s2225.findWinners(nums);//[[1,2,10],[4,5,7,8]]
        for (List<Integer> winner : winners) {
            for (Integer i : winner) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}

package leetcode_days.daily.D20240706;

import java.util.*;

public class S207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Arrays.sort(prerequisites, Comparator.comparingInt(a -> a[1]));
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] mark = new int[5000];
        Arrays.fill(mark, -1);
        Set<Integer> set;
        Set<Integer> zero = new HashSet<>();
        Set<Integer> temp = new HashSet<>();
        for (int[] prerequisite : prerequisites) {
            set = map.getOrDefault(prerequisite[1], new HashSet<>());
            set.add(prerequisite[0]);
            map.put(prerequisite[1], set);
            if (mark[prerequisite[1]] == -1) {
                mark[prerequisite[1]] = 0;
                zero.add(prerequisite[1]);
            }
            if (mark[prerequisite[0]] == -1) {
                mark[prerequisite[0]] = 0;
                zero.add(prerequisite[0]);
            }
            mark[prerequisite[0]]++;
            zero.remove(prerequisite[0]);
        }
        while (!zero.isEmpty()) {
            numCourses -= zero.size();
            if (numCourses <= 0) {
                return true;
            }
            for (Integer i : zero) {
                Set<Integer> next = map.get(i);
                if(next!=null){
                    for (Integer inner : next) {
                        if (mark[inner] == 1) {
                            temp.add(inner);
                        }
                        mark[inner]--;
                    }
                }
            }
            zero.clear();
            zero.addAll(temp);
            temp.clear();
        }
        return false;
    }

    public static void main(String[] args) {
        S207 s207 = new S207();
        System.out.println(s207.canFinish(2, new int[][]{{1, 0}}));
    }
}

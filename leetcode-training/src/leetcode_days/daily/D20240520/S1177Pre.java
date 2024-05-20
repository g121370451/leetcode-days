package leetcode_days.daily.D20240520;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class S1177Pre {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[][] fill = new int[s.length() + 1][26];
        char[] array = s.toCharArray();
        for (int index = 0; index < array.length; index++) {
            fill[index + 1] = fill[index].clone();
            fill[index + 1][array[index] - 'a'] ^= 1;
        }
        int i, j, k, count, inner_index;
        List<Boolean> res = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            i = query[0];
            j = query[1];
            k = query[2];
            count = 0;
            for (inner_index = 0; inner_index < 26; inner_index++) {
                count += fill[j + 1][inner_index] ^ fill[i][inner_index];
            }
            res.add(count / 2 <= k);
        }
        return res;
    }

    public static void main(String[] args) {
        S1177Pre s1177Pre = new S1177Pre();
        //[true,false,false,true,true]
        int[][] queries = {{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}};
        for (Boolean abcda : s1177Pre.canMakePaliQueries("abcda", queries)) {
            System.out.println(abcda);
        }
    }
}

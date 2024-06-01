package leetcode_days.daily.D20240531;

public class S2965 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int len = grid.length;
        int[] mark = new int[len * len + 1];
        for (int[] ints : grid) {
            for (int anInt : ints) {
                ++mark[anInt];
            }
        }
        int[] res = new int[2];
        for (int i = 0; i < mark.length; i++) {
            if (mark[i] == 2) {
                res[0] = i;
            }
            if (mark[i] == 0) {
                res[1] = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        S2965 s2965 = new S2965();
        for (int missingAndRepeatedValue : s2965.findMissingAndRepeatedValues(new int[][]{{1, 3}, {2, 2}})) {
            System.out.println(missingAndRepeatedValue);
        }

    }
}

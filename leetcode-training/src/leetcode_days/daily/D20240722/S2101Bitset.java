package leetcode_days.daily.D20240722;

import java.util.BitSet;

public class S2101Bitset {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        BitSet[] f = new BitSet[n];
        for (int i = 0; i < n; i++) {
            long x = bombs[i][0], y = bombs[i][1], r = bombs[i][2];
            f[i] = new BitSet(n);
            for (int j = 0; j < n; j++) {
                long dx = x - bombs[j][0];
                long dy = y - bombs[j][1];
                if (dx * dx + dy * dy <= r * r) {
                    f[i].set(j); // i 可以到达 j
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (BitSet fi : f) {
                if (fi.get(k)) { // i 可以到达 k
                    fi.or(f[k]); // i 也可以到 k 可以到达的点
                }
            }
        }

        int ans = 0;
        for (BitSet s : f) {
            ans = Math.max(ans, s.cardinality()); // 集合大小的最大值
        }
        return ans;
    }

    public static void main(String[] args) {
        S2101Bitset s2101Bitset = new S2101Bitset();
        s2101Bitset.maximumDetonation(new int[][]{{2, 1, 3}, {6, 1, 4}});
//        s2101Bitset.maximumDetonation(new int[][]{{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}});
//        System.out.println(s2101Bitset.maximumDetonation(new int[][]{{1, 1, 100000}, {100000, 100000, 1}}));
    }
}

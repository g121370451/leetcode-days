package leetcode_days.daily.D20240722;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S2101 {
    public int maximumDetonation1(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            long x = bombs[i][0], y = bombs[i][1], r = bombs[i][2];
            for (int j = 0; j < n; j++) {
                long dx = x - bombs[j][0];
                long dy = y - bombs[j][1];
                if (j != i && dx * dx + dy * dy <= r * r) {
                    g.get(i).add(j); // i 可以引爆 j
                }
            }
        }

        int ans = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(vis, false);
            ans = Math.max(ans, dfs(g, vis, i));
        }
        return ans;
    }

    private int dfs(List<List<Integer>> g, boolean[] vis, int x) {
        vis[x] = true;
        int cnt = 1;
        for (int y : g.get(x)) {
            if (!vis[y]) {
                cnt += dfs(g, vis, y);
            }
        }
        return cnt;
    }


    List<List<Integer>> graph;
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        graph = new ArrayList<>();
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0;i<n;i++){
            long x = bombs[i][0];
            long y = bombs[i][1];
            long r = bombs[i][2];
            for(int j = 0;j<n;j++){
                if(i == j){
                    continue;
                }
                long x_j = bombs[j][0];
                long y_j = bombs[j][1];
                if((x-x_j) * (x-x_j) + (y-y_j) * (y-y_j) <= r*r){
                    graph.get(i).add(j);
                }
            }
        }
        boolean[] vis = new boolean[n];
        int res=1;
        for(int i =0;i<n;i++){
            Arrays.fill(vis,false);
            vis[i] = true;
            res = Math.max(res,dfs(i,vis,1));
        }
        return res;
    }
    private int dfs(int i,boolean[] vis,int cnt){
        for(int j:graph.get(i)){
            if(!vis[j]){
                ++cnt;
                vis[j] = true;
                cnt = dfs(j,vis,cnt);
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        S2101 s2101 = new S2101();
//        s2101.maximumDetonation(new int[][]{{2, 1, 3}, {6, 1, 4}});
//        s2101.maximumDetonation(new int[][]{{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}});
        System.out.println(s2101.maximumDetonation(new int[][]{{1, 1, 100000}, {100000, 100000, 1}}));
    }
}

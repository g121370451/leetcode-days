package leetcode_days.daily.D20240715;

import java.util.*;

public class S721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                map.computeIfAbsent(accounts.get(i).get(j),x->new ArrayList<>()).add(i);
            }
        }
        boolean[] vis = new boolean[accounts.size()];
        Set<String> emailSet = new HashSet<>(); // 用于收集 DFS 中访问到的邮箱地址
        for (int i = 0; i < accounts.size(); i++) {
            if (vis[i]) {
                continue;
            }
            emailSet.clear();
            dfs(i, accounts, map, vis, emailSet);

            List<String> list = new ArrayList<>(emailSet);
            Collections.sort(list);
            list.addFirst(accounts.get(i).getFirst());

            res.add(list);
        }
        return res;
    }
    private void dfs(int i, List<List<String>> accounts, Map<String, List<Integer>> emailToIdx, boolean[] vis, Set<String> emailSet) {
        vis[i] = true;
        for (int k = 1; k < accounts.get(i).size(); k++) {
            String email = accounts.get(i).get(k);
            if (emailSet.contains(email)) {
                continue;
            }
            emailSet.add(email);
            for (int j : emailToIdx.get(email)) { // 遍历所有包含该邮箱地址的账户下标 j
                if (!vis[j]) { // j 没有访问过
                    dfs(j, accounts, emailToIdx, vis, emailSet);
                }
            }
        }
    }
    public static void main(String[] args) {
        S721 s721 = new S721();
//        List<List<String>> lists = new ArrayList<>();
//        lists.add(List.of("John","johnsmith@mail.com","john_newyork@mail.com"));
//        lists.add(List.of("John","johnsmith@mail.com","john00@mail.com"));
//        lists.add(List.of("Mary","mary@mail.com"));
//        lists.add(List.of("John","johnnybravo@mail.com"));
//        for (List<String> strings : s721.accountsMerge(lists)) {
//            for (String string : strings) {
//                System.out.print(string +",");
//            }
//            System.out.println(" ");
//        }
        List<List<String>> lists1 = new ArrayList<>();
        lists1.add(List.of("Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"));
        lists1.add(List.of("Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"));
        lists1.add(List.of("Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"));
        lists1.add(List.of("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"));
        lists1.add(List.of("Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"));
        for (List<String> strings : s721.accountsMerge(lists1)) {
            for (String string : strings) {
                System.out.print(string +",");
            }
            System.out.println(" ");
        }
    }
}

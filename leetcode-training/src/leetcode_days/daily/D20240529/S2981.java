package leetcode_days.daily.D20240529;

import java.util.*;

public class S2981 {

    public int maximumLengthWrong(String s) {
        HashMap<String, Integer> map = getStringIntegerHashMap(s);
        int res = -1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int i = Integer.parseInt(entry.getKey().substring(1));
            if (entry.getValue() >= 3) {
                res = Math.max(res, i);
            } else if (i >= 3) {
                res = Math.max(res, i - 2);
            }
        }
        return res;
    }

    private HashMap<String, Integer> getStringIntegerHashMap(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        int count = 1;
        char[] charArray = s.toCharArray();
        char pre = charArray[0];
        for (int i = 1; i < s.length(); i++) {
            if (charArray[i] == pre) {
                ++count;
            } else {
                int numAdd = 1;
                while (count > 0) {
                    String substring = pre + String.valueOf(count--);
                    Integer num = map.getOrDefault(substring, 0);
                    map.put(substring, num + numAdd++);
                    if (num + 1 >= 3) {
                        break;
                    }
                }
                count = 1;
                pre = charArray[i];
            }
        }
        int numAdd = 1;
        while (count > 0) {
            String substring = pre + String.valueOf(count--);
            Integer num = map.getOrDefault(substring, 0);
            map.put(substring, num + numAdd++);
            if (num + 1 >= 3) {
                break;
            }
        }
        return map;
    }

    public int maximumLength(String S) {
        char[] s = S.toCharArray();
        List<Integer>[] groups = new ArrayList[26];
        Arrays.setAll(groups, i -> new ArrayList<>());
            int cnt = 0;
            for (int i = 0; i < s.length; i++) {
                cnt++;
                if (i + 1 == s.length || s[i] != s[i + 1]) {
                    groups[s[i] - 'a'].add(cnt); // 统计连续字符长度
                    cnt = 0;
                }
            }

            int ans = 0;
            for (List<Integer> a : groups) {
                if (a.isEmpty()) continue;
                a.sort(Collections.reverseOrder());
                a.add(0);
            a.add(0); // 假设还有两个空串
            ans = Math.max(ans, Math.max(a.get(0) - 2, Math.max(Math.min(a.get(0) - 1, a.get(1)), a.get(2))));
        }

        return ans > 0 ? ans : -1;
    }

    public static void main(String[] args) {
        S2981 s2981 = new S2981();
//        System.out.println(s2981.maximumLength("abcaba"));
//        System.out.println(s2981.maximumLength("aaa"));
//        System.out.println(s2981.maximumLength("eccdnmcnkl"));
        System.out.println(s2981.maximumLength("aaaaaaaaaaaaaaaaaaaabbbbbbbbbbaaaaaaaaaaaaaaaaaaaa"));
    }
}

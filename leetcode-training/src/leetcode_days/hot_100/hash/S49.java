package leetcode_days.hot_100.hash;

import java.util.*;

// 字母异位词 可以排序 可以hash
public class S49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String afterSorted = new String(charArray);
            map.computeIfAbsent(afterSorted, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        S49 s49 = new S49();

        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> res = s49.groupAnagrams(words);
        for (List<String> re : res) {
            for (String s : re) {
                System.out.print(s);
            }
            System.out.println("\\");
        }
    }
}

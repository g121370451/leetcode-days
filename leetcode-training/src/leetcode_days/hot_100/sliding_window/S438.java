package leetcode_days.hot_100.sliding_window;

import java.util.LinkedList;
import java.util.List;

public class S438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if (p.length() > s.length()) {
            return res;
        }
        int[] target = new int[26];
        int pLength = p.length();
        int isNotZero = 0;
        int index;
        for (char c : p.toCharArray()) {
            index = (int) c - 'a';
            if (target[index] == 0) {
                ++isNotZero;
            }
            ++target[index];
        }
        char[] sCharArray = s.toCharArray();
        for (int i = 0; i < pLength; i++) {
            index = (int) (sCharArray[i]) - 'a';
            if (target[index] == 0) {
                ++isNotZero;
            }
            --target[index];
            if (target[index] == 0) {
                --isNotZero;
            }
        }
        if (isNotZero == 0) {
            res.add(0);
        }
        for (int j = pLength; j < s.length(); j++) {
            int leftIndex = (int) sCharArray[j - pLength] - 'a';
            int rightIndex = (int) sCharArray[j] - 'a';
            if (target[leftIndex] == 0) {
                isNotZero++;
            } else if (target[leftIndex] == -1) {
                isNotZero--;
            }
            ++target[leftIndex];
            if (target[rightIndex] == 0) {
                isNotZero++;
            } else if (target[rightIndex] == 1) {
                isNotZero--;
            }
            --target[rightIndex];
            if (isNotZero == 0) {
                res.add(j - pLength + 1);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        S438 s438 = new S438();
//        String s = "cbaebabacd", p = "abc";
//        String s = "baa", p = "aa";
        String s = "baa", p = "aa";
        List<Integer> anagrams = s438.findAnagrams(s, p);
        for (Integer anagram : anagrams) {
            System.out.print(anagram + ",");
        }
    }
}

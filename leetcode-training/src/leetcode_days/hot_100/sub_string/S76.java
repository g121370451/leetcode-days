package leetcode_days.hot_100.sub_string;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

// ADOBEOCDAEBANC
// A3 B2 C2 D2
// ABCD
public class S76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> charMapSum = new HashMap<>();
        int isNotZeroNum = 0;
        for (char c : t.toCharArray()) {
            if (!charMapSum.containsKey(c)) {
                ++isNotZeroNum;
            }
            charMapSum.put(c, charMapSum.getOrDefault(c, 0) + 1);
        }
        int startIndex = -1;
        int endIndex = -1;
        int startTemp;
        int endTemp;
        int resLen = 1000001;
        char[] sCharArray = s.toCharArray();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < sCharArray.length; i++) {
            char c = sCharArray[i];
            if (charMapSum.containsKey(c)) {
                Integer cSum = charMapSum.get(c);
                if (cSum == 1) {
                    --isNotZeroNum;
                }
                queue.add(i);
                charMapSum.put(c, cSum - 1);
            }
            while (!queue.isEmpty() && isNotZeroNum == 0) {
                startTemp = queue.poll();
                char addChar = sCharArray[startTemp];
                Integer addCharSum = charMapSum.get(addChar);
                if (addCharSum == 0) {
                    ++isNotZeroNum;
                }
                charMapSum.put(addChar, addCharSum + 1);
                endTemp = i + 1;
                if (endTemp - startTemp < resLen) {
                    startIndex = startTemp;
                    endIndex = endTemp;
                    resLen = endIndex - startIndex;
                }
            }
        }
        if (endIndex == -1) {
            return "";
        }
        return s.substring(startIndex, endIndex);
    }

    public static void main(String[] args) {
        S76 s76 = new S76();
//        String s = "ADOBECODEBANC", t = "ABC";
        String s = "bba", t = "ab";
        String s1 = s76.minWindow(s, t);
        System.out.println(s1);
    }
}

package leetcode_days.hot_100.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//3. 无重复字符的最长子串
public class S3 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> map = new HashSet<>(s.length());
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < len) {
            if (!map.contains(charArray[right])) {
                map.add(charArray[right]);
            } else {
                res = Math.max(res, right - left);
                while (charArray[left] != charArray[right]) {
                    map.remove(charArray[left++]);
                }
                left++;
            }
            ++right;
        }
        return Math.max(res, right - left);
    }

    public int lengthOfLongestSubstringHash(String s) {
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < len) {
            if (map.containsKey(charArray[right]) && map.get(charArray[right]) >= left) {
                res = Math.max(res, right - left);
                left = map.get(charArray[right]) + 1;
            }
            map.put(charArray[right], right);
            ++right;
        }
        return Math.max(res, right - left);
    }

    public static void main(String[] args) {
        S3 s3 = new S3();
        System.out.println(s3.lengthOfLongestSubstring("abcabcbb"));// 3
        System.out.println(s3.lengthOfLongestSubstring(" "));// 3
    }

}

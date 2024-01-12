package leetcode_days;

import java.util.HashMap;
import java.util.Map;

/**
 * 2085. Count Common Words With One Occurrence
 * 统计出现过一次的公共字符串
 * 给你两个字符串数组 words1 和 words2 ，请你返回在两个字符串数组中 都恰好出现一次 的字符串的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","leetcode","is"]
 * 输出：2
 * 解释：
 * - "leetcode" 在两个数组中都恰好出现一次，计入答案。
 * - "amazing" 在两个数组中都恰好出现一次，计入答案。
 * - "is" 在两个数组中都出现过，但在 words1 中出现了 2 次，不计入答案。
 * - "as" 在 words1 中出现了一次，但是在 words2 中没有出现过，不计入答案。
 * 所以，有 2 个字符串在两个数组中都恰好出现了一次。
 * 示例 2：
 *
 * 输入：words1 = ["b","bb","bbb"], words2 = ["a","aa","aaa"]
 * 输出：0
 * 解释：没有字符串在两个数组中都恰好出现一次。
 * 示例 3：
 *
 * 输入：words1 = ["a","ab"], words2 = ["a","a","a","ab"]
 * 输出：1
 * 解释：唯一在两个数组中都出现一次的字符串是 "ab" 。
 *
 *
 * 使用hash打表的方法 统计次数
 */
public class D20240112 {
    public int countWords(String[] words1, String[] words2) {
        int result = 0;
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (String s : words1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        for (String s : words2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (entry.getValue() == 1 && map2.getOrDefault(entry.getKey(), 0) == 1) {
                result++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        String[] a = {"leetcode", "is", "amazing", "as", "is"};
        String[] b = {"amazing", "leetcode", "is"};
        D20240112 d = new D20240112();
        System.out.println(d.countWords(a, b));
    }
}

package leetcode_days;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2744. 最大字符串配对数目
 * 简单
 * <p>
 * 给你一个下标从 0 开始的数组 words ，数组中包含 互不相同 的字符串。
 * <p>
 * 如果字符串 words[i] 与字符串 words[j] 满足以下条件，我们称它们可以匹配：
 * <p>
 * 字符串 words[i] 等于 words[j] 的反转字符串。
 * 0 <= i < j < words.length
 * 请你返回数组 words 中的 最大 匹配数目。
 * <p>
 * 注意，每个字符串最多匹配一次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["cd","ac","dc","ca","zz"]
 * 输出：2
 * 解释：在此示例中，我们可以通过以下方式匹配 2 对字符串：
 * - 我们将第 0 个字符串与第 2 个字符串匹配，因为 word[0] 的反转字符串是 "dc" 并且等于 words[2]。
 * - 我们将第 1 个字符串与第 3 个字符串匹配，因为 word[1] 的反转字符串是 "ca" 并且等于 words[3]。
 * 可以证明最多匹配数目是 2 。
 * 示例 2：
 * <p>
 * 输入：words = ["ab","ba","cc"]
 * 输出：1
 * 解释：在此示例中，我们可以通过以下方式匹配 1 对字符串：
 * - 我们将第 0 个字符串与第 1 个字符串匹配，因为 words[1] 的反转字符串 "ab" 与 words[0] 相等。
 * 可以证明最多匹配数目是 1 。
 * 示例 3：
 * <p>
 * 输入：words = ["aa","ab"]
 * 输出：0
 * 解释：这个例子中，无法匹配任何字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 50
 * words[i].length == 2
 * words 包含的字符串互不相同。
 * words[i] 只包含小写英文字母。
 * <p>
 * <u> 因为题目限制字符串长度为2 小写字符 所以可以优化反转算法 使用字符串化整数的方法 a*1000+b 但是a-z为97-122 所以可以使用 a*100+b也不会冲突 进一步优化 </u>
 * </p>
 */
public class D20240117 {
    public String reverseTestSeven(String s) {

        int length = s.length();

        if (length <= 1) return s;

        String left = s.substring(0, length / 2);

        String right = s.substring(length / 2, length);

        return reverseTestSeven(right) + reverseTestSeven(left);

    }

    public int maximumNumberOfStringPairsElder(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int result = 0;
        for (String word : words) {
            if (map.containsKey(word)) {
                result++;
            } else {
                map.put(word, 1);
                map.put(reverseTestSeven(word), 1);
            }
        }
        return result;
    }

    public int maximumNumberOfStringPairs(String[] words) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for (String word : words) {
            int i = word.charAt(0) * 100 + word.charAt(1);
            if (set.contains(i)) {
                result++;
            } else {
                set.add(i);
                set.add(word.charAt(1)*100 + word.charAt(0));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        D20240117 d20240117 = new D20240117();
        String[] strings1 = {"cd", "ac", "dc", "ca", "zz"};
        String[] strings2 = {"ab","ba","cc"};
        String[] strings3 = {"aa","ab"};
        System.out.println(d20240117.maximumNumberOfStringPairs(strings1));
        System.out.println(d20240117.maximumNumberOfStringPairs(strings2));
        System.out.println(d20240117.maximumNumberOfStringPairs(strings3));
    }

}

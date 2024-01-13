package leetcode_days;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 2182. Construct String With Repeat Limit
 * 构造限制重复的字符串
 * 给你一个字符串 s 和一个整数 repeatLimit ，用 s 中的字符构造一个新字符串 repeatLimitedString ，使任何字母 连续 出现的次数都不超过 repeatLimit 次。你不必使用 s 中的全部字符。
 * <p>
 * 返回 字典序最大的 repeatLimitedString 。
 * <p>
 * 如果在字符串 a 和 b 不同的第一个位置，字符串 a 中的字母在字母表中出现时间比字符串 b 对应的字母晚，则认为字符串 a 比字符串 b 字典序更大 。如果字符串中前 min(a.length, b.length) 个字符都相同，那么较长的字符串字典序更大。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "cczazcc", repeatLimit = 3
 * 输出："zzcccac"
 * 解释：使用 s 中的所有字符来构造 repeatLimitedString "zzcccac"。
 * 字母 'a' 连续出现至多 1 次。
 * 字母 'c' 连续出现至多 3 次。
 * 字母 'z' 连续出现至多 2 次。
 * 因此，没有字母连续出现超过 repeatLimit 次，字符串是一个有效的 repeatLimitedString 。
 * 该字符串是字典序最大的 repeatLimitedString ，所以返回 "zzcccac" 。
 * 注意，尽管 "zzcccca" 字典序更大，但字母 'c' 连续出现超过 3 次，所以它不是一个有效的 repeatLimitedString 。
 * 示例 2：
 * <p>
 * 输入：s = "aababab", repeatLimit = 2
 * 输出："bbabaa"
 * 解释：
 * 使用 s 中的一些字符来构造 repeatLimitedString "bbabaa"。
 * 字母 'a' 连续出现至多 2 次。
 * 字母 'b' 连续出现至多 2 次。
 * 因此，没有字母连续出现超过 repeatLimit 次，字符串是一个有效的 repeatLimitedString 。
 * 该字符串是字典序最大的 repeatLimitedString ，所以返回 "bbabaa" 。
 * 注意，尽管 "bbabaaa" 字典序更大，但字母 'a' 连续出现超过 2 次，所以它不是一个有效的 repeatLimitedString 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= repeatLimit <= s.length <= 105
 * s 由小写英文字母组成
 */
public class D20240113 {
//    public char[] quickSort(char[] s, int left, int right) {
//        if (left < right) {
//            int partition = partition(s, left, right);
//            quickSort(s, left, partition - 1);
//            quickSort(s, partition + 1, right);
//        }
//        return s;
//    }
//
//    private int partition(char[] charArray, int left, int right) {
//        int pivot = charArray[left];
//        while (left < right) {
//            while (left < right && (int) charArray[right] < pivot) right--;
//            if (left < right) charArray[left++] = charArray[right];
//            while (left < right && (int) charArray[left] > pivot) left++;
//            if (left < right) charArray[right--] = charArray[left];
//        }
//        charArray[left] = (char) pivot;
//        return left;
//    }
//
//    public boolean swapCharArray(char[] arr, char pre, int preIndex) {
//        for (int tempIndex = preIndex + 1; tempIndex < arr.length && arr[tempIndex] < pre; tempIndex++) {
//            char temp = arr[preIndex];
//            arr[preIndex] = arr[tempIndex];
//            arr[tempIndex] = temp;
//            return true;
//        }
//        return false;
//    }
//
//    public String repeatLimitedString(String s, int repeatLimit) {
//        char[] chars = quickSort(s.toCharArray(), 0, s.length() - 1);
//        if (s.length() == 1) return s;
//        int count = 1;
//        char pre = chars[0];
//        for (int index = 1; index < chars.length; index++) {
//            if (chars[index] == pre) {
//                count++;
//            } else {
//                pre = chars[index];
//                count = 1;
//            }
//            if (count > repeatLimit) {
//                if (!swapCharArray(chars, pre, index)) {
//                    return String.valueOf(Arrays.copyOfRange(chars, 0, index));
//                }
//                count = 1;
//                index++;
//            }
//        }
//        return String.valueOf(chars);
//    }
static public int N = 26;
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[N];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder ret = new StringBuilder();
        int m = 0;
        for (int i = N - 1, j = N - 2; i >= 0 && j >= 0;) {
            if (count[i] == 0) { // 当前字符已经填完，填入后面的字符，重置 m
                m = 0;
                i--;
            } else if (m < repeatLimit) { // 当前字符未超过限制
                count[i]--;
                ret.append((char)('a' + i));
                m++;
            } else if (j >= i || count[j] == 0) { // 当前字符已经超过限制，查找可填入的其他字符
                j--;
            } else { // 当前字符已经超过限制，填入其他字符，并且重置 m
                count[j]--;
                ret.append((char)('a' + j));
                m = 0;
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        D20240113 d = new D20240113();
        //yxxrrrrqppliddd
        //yxxrrrrqppliddd
        System.out.printf(d.repeatLimitedString("pdprlxqryxdirdr", 10));
    }
}

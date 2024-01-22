package leetcode_days;

import java.util.Arrays;

/**
 * 670. 最大交换
 * 中等
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * <p>
 * 示例 1 :
 * <p>
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 * <p>
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * 注意:
 * <p>
 * 给定数字的范围是 [0, 108]
 * <u>
 * <p>
 * 选择排序 选择最靠后的最大值 如果选择到就直接返回 选择不到就查找下一位
 * </p>
 * </u>
 */
public class D20240122 {
    public int maximumSwap(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int index = i;
            char max = charArray[i];
            for (int j = charArray.length - 1; j > i; j--) {
                if (charArray[j] > max) {
                    index = j;
                    max = charArray[j];
                }
            }
            if (index != i) {
                char temp = charArray[i];
                charArray[i] = charArray[index];
                charArray[index] = temp;
                StringBuilder sb = new StringBuilder();
                for (char c : charArray) {
                    sb.append(c);
                }
                return Integer.parseInt(sb.toString());
            }
        }
        return num;
    }

    public static void main(String[] args) {
        D20240122 d = new D20240122();
        System.out.println(d.maximumSwap(2736));
        System.out.println(d.maximumSwap(9973));
        System.out.println(d.maximumSwap(98368));
        System.out.println(d.maximumSwap(1993));
    }
}

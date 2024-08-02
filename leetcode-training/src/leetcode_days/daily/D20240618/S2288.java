package leetcode_days.daily.D20240618;

import java.math.BigDecimal;

public class S2288 {
    public String discountPrices(String sentence, int discount) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        char[] array = sentence.toCharArray();
        Long temp = null;
        boolean flag;
        while (i < array.length) {
            if (array[i] != '$') {
                while (i < array.length && array[i] != ' ') {
                    sb.append(array[i++]);
                }
                if (i < array.length) {
                    sb.append(array[i++]);
                }
            } else {
                sb.append(array[i++]);
                flag = true;
                while (i < array.length && array[i] != ' ') {
                    if (array[i] >= '0' && array[i] <= '9') {
                        if (temp == null) {
                            temp = 0L;
                        }
                        temp = temp * 10 + array[i++] - '0';
                    } else {
                        flag = false;
                        if (temp != null) {
                            sb.append(temp);
                        }
                        sb.append(array[i++]);
                        temp = null;
                    }
                }
                if (flag && temp != null) {
                    sb.append(String.format("%.2f", temp * (100 - discount) / 100D));
                } else if (temp != null) {
                    sb.append(temp);
                }
                temp = null;
                if (i < array.length) {
                    sb.append(array[i++]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        S2288 s2288 = new S2288();
        System.out.println(s2288.discountPrices("there are $1 $2 and 5$ candies in the shop", 50));
    }
}

package leetcode_days.weekly.W20240728;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q3 {
    int res;
    char[] array;
    boolean[] visited;
    int len;

    int oneCount;

    public int numberOfSubstrings1(String s) {
        res = 0;
        array = s.toCharArray();
        len = array.length;
        int size = (len + 1) * len / 2;
        visited = new boolean[size];
        oneCount = 0;
        for (int i = 0; i < len; i++) {
            if (array[i] == '1') {
                ++oneCount;
            }
        }
        for (int i = 0; i < len; i++) {
            if (array[i] == '1') {
                dfs(i, i, 0, 1);
            }
        }
        return res;
    }

    private void dfs(int i, int j, int zeroNum, int oneNum) {
        int index = (len + (len - i + 1)) * i / 2 + j - i;
        if (visited[index]) {
            return;
        }
        if (oneNum >= zeroNum * zeroNum) {
            ++res;
            visited[index] = true;
        } else {
            visited[index] = true;
            if (oneCount < zeroNum * zeroNum) {
                return;
            }
        }
        if (i - 1 >= 0) {
            int indexPre = (len + (len - i + 2)) * (i - 1) / 2 + j - i + 1;
            if (!visited[indexPre]) {
                if (array[i - 1] == '1') {
                    dfs(i - 1, j, zeroNum, oneNum + 1);
                } else {
                    dfs(i - 1, j, zeroNum + 1, oneNum);
                }

            }
        }
        if (j + 1 < len) {
            int indexAfter = index + 1;
            if (!visited[indexAfter]) {
                if (array[j + 1] == '1') {
                    dfs(i, j + 1, zeroNum, oneNum + 1);
                } else {
                    dfs(i, j + 1, zeroNum + 1, oneNum);
                }

            }
        }
    }

    public int numberOfSubstrings(String s) {
        char[] array = s.toCharArray();
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '0') {
                list.add(i);
            }
        }
        list.add(array.length);
        int maxZero = (int) Math.sqrt(array.length);
        // 遍历左端点
        for (int i = 0; i < array.length; i++) {
            int cnt0 = 0;
            int preIndex = array[i] == '0' ? i + 1 : i;
            int preCount = 0;
            for (int index : list) {
                if (index > i) {
                    res += index - preIndex + (cnt0 * cnt0 - preCount);
                    ++cnt0;
                    preCount += index - preIndex - 1;
                    preIndex = index;
                }
                if (cnt0 >= maxZero) {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q3 q3 = new Q3();
//        System.out.println(q3.numberOfSubstrings("00011"));
        System.out.println(q3.numberOfSubstrings("101101"));
    }
}

package leetcode_days.hot_100.double_pointer;

import java.util.LinkedList;

// 使用单调栈 里面只保存可能得最大值 什么情况下不可能呢 就是右侧比左侧小 那么判断左侧的下一个最大值时 小的值永远不可能再出现了 （右往左）
public class S42ExtendStackS739 {
    public int[] dailyTemperaturesRightToLeft(int[] temperatures) {
        int len = temperatures.length;
        LinkedList<Integer> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return res;
    }

    public int[] dailyTemperaturesLeftToRight(int[] temperatures) {
        int len = temperatures.length;
        LinkedList<Integer> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                res[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return res;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        return dailyTemperaturesLeftToRight(temperatures);
    }

    public static void main(String[] args) {
        S42ExtendStackS739 s42ExtendStackS739 = new S42ExtendStackS739();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};//[1,1,4,2,1,1,0,0]
        int[] ints = s42ExtendStackS739.dailyTemperatures(temperatures);
        for (int anInt : ints) {
            System.out.print(anInt + ",");
        }
    }
}

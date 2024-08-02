package leetcode_days.hot_100.stack;

import java.util.ArrayDeque;

public class S84 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] pre = new int[len];
        int[] after = new int[len];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty() && heights[deque.peekFirst()] > heights[i]) {
                int temp = deque.pollFirst();
                after[temp] = i - 1 - temp;
            }
            deque.addFirst(i);
        }
        while (!deque.isEmpty()) {
            int temp = deque.pollFirst();
            after[temp] = len - 1 - temp;
        }
        for (int i = len - 1; i >= 0; i--) {
            while (!deque.isEmpty() && heights[deque.peekFirst()] > heights[i]) {
                int temp = deque.pollFirst();
                pre[temp] = temp - i - 1;
            }
            deque.addFirst(i);
        }
        while (!deque.isEmpty()) {
            int temp = deque.pollFirst();
            pre[temp] = temp;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, (pre[i] + after[i] + 1) * heights[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        S84 s84 = new S84();
        System.out.println(s84.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(s84.largestRectangleArea(new int[]{1, 1}));
    }
}

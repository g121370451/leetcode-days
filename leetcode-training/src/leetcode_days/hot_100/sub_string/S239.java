package leetcode_days.hot_100.sub_string;

import java.util.*;

//239. 滑动窗口最大值
// 双端队列 deque 只保存结果 不保存一些中间的无用数据 无用数据判断-> 被窗口后面的数字包围的数字
public class S239 {

    private void pushNewNum(ArrayDeque<Integer> deque, int num) {
        if (deque.isEmpty() || num < deque.peekFirst()) {
            deque.addFirst(num);
        } else {
            while (!deque.isEmpty() && num > deque.peekFirst()) {
                deque.pollFirst();
            }
            deque.addFirst(num);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int thisNum;
        int newNum;
        for (int i = 0; i < k; i++) {
            thisNum = nums[i];
            pushNewNum(deque, thisNum);
        }
        res[0] = deque.peekLast();
        for (int index = k; index < nums.length; index++) {
            newNum = nums[index];
            thisNum = nums[index - k];
            if (thisNum == deque.peekLast()) {
                deque.pollLast();
            }
            pushNewNum(deque, newNum);
            res[index - k + 1] = deque.peekLast();
        }
        return res;
    }

    public static void main(String[] args) {
        // 3 1 2 1 -1 5 3
        // 2 3 1 -1 -1
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7}; //[3,3,5,5,6,7]
        int k = 3;
        S239 s239 = new S239();
        int[] ints = s239.maxSlidingWindow(nums, k);
        for (int anInt : ints) {
            System.out.print(anInt + ",");
        }
    }
}

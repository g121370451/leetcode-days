package leetcode_days.hot_100.double_pointer;

import java.util.LinkedList;

// 可以使用
public class S42 {


    public int trapStack(int[] height) {
        LinkedList<Integer> stack = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottomHeight = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                int index = stack.peek();
                res += (Math.min(height[stack.peek()], height[i]) - bottomHeight) * (i - index - 1);
            }
            stack.push(i);
        }
        return res;
    }

    public int trapPreSuffix(int[] height) {
        int res = 0;
        int len = height.length;
        if (len == 1 || len == 2) {
            return res;
        }
        int[] prefix = new int[len];
        prefix[0] = height[0];
        int[] suffix = new int[len];
        suffix[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            prefix[i] = Math.max(height[i], prefix[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            suffix[i] = Math.max(height[i], suffix[i + 1]);
        }
        for (int i = 0; i < len; i++) {
            res += Math.min(prefix[i], suffix[i]) - height[i];
        }
        return res;
    }

    public int trap(int[] height) {
        return trapStack(height);
    }

    public static void main(String[] args) {
//        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; // 6
        int[] nums = {4, 2, 0, 3, 2, 5}; // 9
        S42 s42 = new S42();
        int trap = s42.trap(nums);
        System.out.println(trap);
    }
}

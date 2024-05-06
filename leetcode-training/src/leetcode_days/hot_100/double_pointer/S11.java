package leetcode_days.hot_100.double_pointer;

// 盛水最多的容器
public class S11 {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int leftNum = 0, rightNum = 0;
        int res = 0;
        // 贪心从最大的宽度查找
        // 如果内侧找 比外侧还低 可以直接忽略
        // 每次都把更小高的那个往内部划 企图找打更大的 找不到就是当前的最大
        while (left < right) {
            while (height[left] < leftNum) {
                ++left;
            }
            while (height[right] < rightNum) {
                --right;
            }
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            leftNum = height[left];
            rightNum = height[right];
            if (leftNum > rightNum) {
                --right;
            } else {
                ++left;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        S11 s11 = new S11();
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7}; // 49
        int i = s11.maxArea(nums);
        System.out.println(i);
    }
}

package leetcode_days.daily.D20240523;


import java.util.*;

//2831. 找出最长等值子数组
public class S2831 {
    // 1, 3, 2, 3, 1, 3
    // 1, 3, 3, 3, 1, 1, 1, 1
    // 1, 3, 3, 2, 2, 2, 1, 3, 3
    // 3, 1, 3, 2, 2, 2, 1, 3, 3
    // k表示可以删除的数量 如果k==0了表示 不能在删除了 就要把头给删除掉 删除掉了之后要恢复k的值 k=原本的k - 除去头以外全部的总和 + 当前的不重复的数量
    // 处理后 在加上当前
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int[] mark = new int[nums.size() + 1];
        int index = 0;
        int maxDelete = k;
        ++mark[nums.get(index)];
        int count = 1;
        int res = 1;
        for (int i = 1; i < nums.size(); i++) {
            //4,1,6,7,5,3,5
            ++mark[nums.get(i)];
            ++count;
            if (!Objects.equals(nums.get(i), nums.get(index))) {
                --k;
                if (k < 0) {
                    while (k < 0 && index < i) {
                        res = Math.max(res, mark[nums.get(index)]);
                        --mark[nums.get(index)];
                        --count;
                        ++index;
                        k = maxDelete - count + mark[nums.get(index)];
                    }
                }
            }
        }
        for (int i : mark) {
            if (i != 0) {
                res = Math.max(res, i);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        S2831 s2831 = new S2831();
        List<Integer> list = new LinkedList<>();
//        int[] nums = {1, 3, 2, 3, 1, 3}; // 3
//        int k = 3;
//        int[] nums = {1};
//        int k = 1;//1
//        int[] nums = {1};
//        int k = 0;//1
//        int[] nums = {1,2,3,4};
//        int k = 0//1
//        int[] nums = {1,2,1};
//        int k = 0;//1
//        int[] nums = {2, 1, 1, 3, 1, 3};
//        int k =2;//3
//        int[] nums = {4, 1, 6, 7, 5, 3, 5};
//        int k = 1;//2
//        int[] nums = {1, 1, 2, 2, 6, 2};
//        int k = 1;//3
//        int[] nums = {3, 2, 1, 4, 1};
//        int k =0;//1
//        int[] nums = {1, 1, 2, 2, 6, 2}; // 3
//        int k = 1;
        int[] nums = {1, 1, 2, 2, 1, 1};
        int k = 2;//4

        for (int num : nums) {
            list.add(num);
        }
//        int k = 0;
        System.out.println(s2831.longestEqualSubarray(list, k));
    }
}

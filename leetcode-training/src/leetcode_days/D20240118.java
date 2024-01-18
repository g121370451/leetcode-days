package leetcode_days;

import java.util.Arrays;

/**
 * <p>
 *    2171. 拿出最少数目的魔法豆
 * </p>
 * <p>
 *    中等
 * </p>
 * <p>
 *    提示
 *    给定一个 正整数 数组 beans ，其中每个整数表示一个袋子里装的魔法豆的数目。
 * </p>
 * 提示
 * <p>
 *     请你从每个袋子中 拿出 一些豆子（也可以 不拿出），使得剩下的 非空 袋子中（即 至少还有一颗 魔法豆的袋子）魔法豆的数目 相等。一旦把魔法豆从袋子中取出，你不能再将它放到任何袋子中。
 * </p>
 * <p>
 *     请返回你需要拿出魔法豆的 最少数目。
 * </p>
 * <p>
 *     示例 1：
 * 输入：beans = [4,1,6,5]
 * 输出：4
 * 解释：
 * - 我们从有 1 个魔法豆的袋子中拿出 1 颗魔法豆。
 *   剩下袋子中魔法豆的数目为：[4,0,6,5]
 * - 然后我们从有 6 个魔法豆的袋子中拿出 2 个魔法豆。
 *   剩下袋子中魔法豆的数目为：[4,0,4,5]
 * - 然后我们从有 5 个魔法豆的袋子中拿出 1 个魔法豆。
 *   剩下袋子中魔法豆的数目为：[4,0,4,4]
 * 总共拿出了 1 + 2 + 1 = 4 个魔法豆，剩下非空袋子中魔法豆的数目相等。
 * 没有比取出 4 个魔法豆更少的方案。
 * </p>
 * <p>
 * 示例 2：
 * 输入：beans = [2,10,3,2]
 * 输出：7
 * 解释：
 * - 我们从有 2 个魔法豆的其中一个袋子中拿出 2 个魔法豆。
 *   剩下袋子中魔法豆的数目为：[0,10,3,2]
 * - 然后我们从另一个有 2 个魔法豆的袋子中拿出 2 个魔法豆。
 *   剩下袋子中魔法豆的数目为：[0,10,3,0]
 * - 然后我们从有 3 个魔法豆的袋子中拿出 3 个魔法豆。
 *   剩下袋子中魔法豆的数目为：[0,10,0,0]
 * 总共拿出了 2 + 2 + 3 = 7 个魔法豆，剩下非空袋子中魔法豆的数目相等。
 * 没有比取出 7 个魔法豆更少的方案。
 *
 * <p>
 * 提示：
 * 1 <= beans.length <= 105
 * 1 <= beans[i] <= 105
 * </p>
 * </p>
 * <u>
 *     <p>
 *         1.还是DP算法 把当前能得到的最好的结果 向下传递 返回结果取最小值
 *         2. 发现DP无法覆盖全部case eg 66 90 47时 把47设置为最小是最好的 但是后面如果出现[66,90,47,25,92,90,76,85,22,3] 66 才是更好的了
 *     </p>
 * </u>
 *
 */
public class D20240118 {
    public static long f_elder(long min_pre,int min_num,int not_zero_num,int[] beans,int index){
        if (index == beans.length){
            return min_pre;
        }
        long result = Long.MAX_VALUE;
        int target = beans[index];
        // 新数比较小
        // 2 10 3 2
        if (target <= min_num){
            // 不需要拿豆子
            if (target == min_num){
                result = Math.min(result,f(min_pre,min_num,not_zero_num+1,beans,index+1));
            }else{
                // 拉齐相比 变为零更简单
                if (not_zero_num * (min_num - target) >= target){
                    result = Math.min(result,f(min_pre+ target,min_num,not_zero_num,beans,index+1));
                }
                // 与变零相比 拉齐更简单
                if (not_zero_num * (min_num- target) <= target){
                    result = Math.min(result,f(min_pre + ((long) not_zero_num * (min_num-target)),target,not_zero_num+1,beans,index+1));
                }
            }
        }else{
            result =  Math.min(result,f(min_pre + target-min_num,min_num,not_zero_num+1,beans,index+1));
        }
        return result;
    }

    public static long f(long min_pre,int min_num,int not_zero_num,int[] beans,int index){
        if (index == beans.length){
            return min_pre;
        }
        long result = Long.MAX_VALUE;
        int target = beans[index];
        // 新数比较小
        // 2 10 3 2
        // 不需要拿豆子
        if (target == min_num){
            result = Math.min(result,f(min_pre,min_num,not_zero_num+1,beans,index+1));
        }else{
            // 拉齐相比 变为零更简单
            result = Math.min(result,f(min_pre+ target,min_num,not_zero_num,beans,index+1));
            // 与变零相比 拉齐更简单
            result = Math.min(result,f(min_pre + ((long) not_zero_num * (min_num-target)),target,not_zero_num+1,beans,index+1));
        }
        return result;
    }

    public int[] quickSort(int[] s, int left, int right) {
        if (left < right) {
            int partition = partition(s, left, right);
            quickSort(s, left, partition - 1);
            quickSort(s, partition + 1, right);
        }
        return s;
    }

    private int partition(int[] charArray, int left, int right) {
        int pivot = charArray[left];
        while (left < right) {
            while (left < right && charArray[right] < pivot) right--;
            if (left < right) charArray[left++] = charArray[right];
            while (left < right && charArray[left] > pivot) left++;
            if (left < right) charArray[right--] = charArray[left];
        }
        charArray[left] = (char) pivot;
        return left;
    }

    public long minimumRemoval_elder(int[] beans) {
        if (beans.length == 1){return 0L;}
        return Math.min(f(0,beans[0],1,beans,1),
                f(beans[0],Integer.MAX_VALUE,0,beans,1));
    }

    public long minimumRemoval_tle(int[] beans) {
        if (beans.length == 1){return 0L;}
        int[] arr = quickSort(beans, 0, beans.length - 1);
        return f(0,beans[0],1,arr,1);
    }

    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long sum = 0, mx = 0;
        int n = beans.length;
        for (int i = 0; i < n; i++) {
            sum += beans[i];
            mx = Math.max(mx, (long) (n - i) * beans[i]);
        }
        return sum - mx;
    }

    public static void main(String[] args) {
        D20240118 d20240118  = new D20240118();
        int[] arr1 = {4,1,6,5};
        int[] arr2 = {2,10,3,2};
        int[] arr3 = {2,1,2,2};
        int[] arr4 = {2,2,1,1};
        int[] arr5 = {4,2,1};
        int[] arr6 = {4};
        int[] arr7 = {66,90,47,25,92,90,76,85,22,3};// 0 + 24 + 47 + 25 + 26 + 24 + 10 + 19 + 22 + 3
        int[] arr8 = {25,27,1,10,8,35,17,5,4,16}; // 8 + 10 + 1 + 10 + 8 + 18 + 0 + 5 + 4 + 16 // 9 + 11 + 1 +10 + 8 + 19 + 1 + 5 + 4 +0
        System.out.println(d20240118.minimumRemoval(arr1));
        System.out.println(d20240118.minimumRemoval(arr2));
        System.out.println(d20240118.minimumRemoval(arr3));
        System.out.println(d20240118.minimumRemoval(arr4));
        System.out.println(d20240118.minimumRemoval(arr5));
        System.out.println(d20240118.minimumRemoval(arr6));
        System.out.println(d20240118.minimumRemoval(arr7));
        System.out.println(d20240118.minimumRemoval(arr8));
    }
}

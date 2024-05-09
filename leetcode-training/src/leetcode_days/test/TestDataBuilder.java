package leetcode_days.test;


import java.util.concurrent.CompletableFuture;

/**
 * 测试数据构造器
 */
public class TestDataBuilder {

    /**
     * 使用多线程对数组添加随机数
     *
     * @param rangeStart 随机数范围开始
     * @param rangeEnd   随机数范围结束
     * @param length     数组长度
     * @param threadNum  线程数
     * @return 返回随机结果的数据
     */
    public int[] buildIntArrayRandom(int rangeStart, int rangeEnd, int length, int threadNum) {
        int[] res = new int[length];
        int len = length / threadNum;
        int elseNum = length % threadNum;
//        CompletableFuture<Integer> completableFuture1 = CompletableFuture.runAsync
        return null;
    }

}

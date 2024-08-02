package leetcode_days.daily.D20240727;

import java.util.ArrayDeque;
import java.util.Arrays;

public class S729 {
    public int[] dailyTemperatures(int[] temperatures) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int len = temperatures.length;
        int[] res = new int[len];
        for(int i = 0;i<len;i++){
            while(!deque.isEmpty() && temperatures[deque.peekFirst()] < temperatures[i]){
                int temp = deque.pollFirst();
                res[temp] = i - temp;
            }
            deque.addFirst(i);
        }
        return res;
    }

    public static void main(String[] args) {
        S729 s729 = new S729();
        //[1,1,4,2,1,1,0,0]
        int[] ints = s729.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int anInt : ints) {
            System.out.print(anInt + ",");
        }
    }
}

package leetcode_days.daily.D20240528;

import java.util.ArrayList;
import java.util.List;

//2951. 找出峰值
public class S2951 {
    public List<Integer> findPeaks(int[] mountain) {
        int index = 1;
        List<Integer> res = new ArrayList<>();
        while (index < mountain.length - 1) {
            if (mountain[index] > mountain[index - 1] && mountain[index] > mountain[index + 1]) {
                res.add(index);
            }
            ++index;
        }
        return res;
    }

    public static void main(String[] args) {
        S2951 s2951 = new S2951();
//        List<Integer> peaks = s2951.findPeaks(new int[]{2, 4, 4});
        List<Integer> peaks = s2951.findPeaks(new int[]{1,4,3,8,5});
        for (Integer peak : peaks) {
            System.out.print(peak + " ");
        }
    }
}

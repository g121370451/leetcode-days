package leetcode_days.daily.D20240511;


//2391. 收集垃圾的最少总时间
public class S2391 {

    public int garbageCollection(String[] garbage, int[] travel) {
        int len = garbage.length;
        int g_len = 0;
        int m_len = 0;
        int p_len = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            char[] charArray = garbage[i].toCharArray();
            for (char c : charArray) {
                if (c == 'G') {
                    g_len = i;
                } else if (c == 'P') {
                    p_len = i;
                } else if (c == 'M') {
                    m_len = i;
                }
                ++res;
            }
        }
        int travel_sum = 0;
        for (int i = 0; i < travel.length; i++) {
            travel_sum += travel[i];
            if (g_len == i + 1) {
                res += travel_sum;
            }
            if (m_len == i + 1) {
                res += travel_sum;
            }
            if (p_len == i + 1) {
                res += travel_sum;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        S2391 s2391 = new S2391();
        String[] garbage = {"G", "P", "GP", "GG"};//21
        int[] travel = {2, 4, 3};
        int i = s2391.garbageCollection(garbage, travel);
        System.out.println(i);
    }
}

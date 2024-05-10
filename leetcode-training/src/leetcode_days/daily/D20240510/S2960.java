package leetcode_days.daily.D20240510;

//2960. 统计已测试设备
public class S2960 {

    public int countTestedDevices(int[] batteryPercentages) {
        int now = 0;
        int res = 0;
        int len = batteryPercentages.length;
        for (int i = 0; i < len; i++) {
            if (batteryPercentages[i] - now > 0) {
                ++res;
                ++now;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        S2960 s2960 = new S2960();
        int[] nums = {1, 1, 2, 1, 3};
        System.out.println(s2960.countTestedDevices(nums));
    }
}

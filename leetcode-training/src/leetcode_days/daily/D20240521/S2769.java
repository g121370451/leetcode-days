package leetcode_days.daily.D20240521;

public class S2769 {
    public int theMaximumAchievableX(int num, int t) {
        return num + t * 2;
    }

    public static void main(String[] args) {
        S2769 s2769 = new S2769();
        System.out.println(s2769.theMaximumAchievableX(4, 1));
    }
}

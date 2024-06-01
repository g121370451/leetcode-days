package leetcode_days.daily.D20240601;


// 2928. 给小朋友们分糖果 I
public class S2928 {

    int res = 0;

    public int distributeCandies(int n, int limit, int childrenNum) {
        int min = Math.max(0, n - limit * (childrenNum - 1));
        int max = Math.min(n, limit);
        if (childrenNum > 2) {
            while (min <= max) {
                res += distributeCandies(n - min++, limit, 2);
            }
            return res;
        }
        return max - min + 1;
    }

    public int distributeCandies(int n, int limit) {
        return distributeCandies(n, limit, 3);
    }

    public static void main(String[] args) {
        S2928 s2928 = new S2928();
        System.out.println(s2928.distributeCandies(5, 2));
//        System.out.println(s2928.distributeCandies(3, 3));
    }
}

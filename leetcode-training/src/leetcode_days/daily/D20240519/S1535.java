package leetcode_days.daily.D20240519;

public class S1535 {

    public int getWinner(int[] arr, int k) {
        int i = 0;
        int j = 1;
        int count = 0;
        while (j < arr.length) {
            if (arr[i] > arr[j]) {
                ++count;
                ++j;
                if (count == k) {
                    return arr[i];
                }
            } else {
                count = 1;
                i = j;
                ++j;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        S1535 s1535 = new S1535();
        int[] arr = {2, 1, 3, 5, 4, 6, 7};
        int k = 2;
        System.out.println(s1535.getWinner(arr, k));
    }
}

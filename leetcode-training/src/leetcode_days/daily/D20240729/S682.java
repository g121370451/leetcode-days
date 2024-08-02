package leetcode_days.daily.D20240729;

public class S682 {
    public int calPoints(String[] operations) {
        int[] nums = new int[operations.length];
        int index = 0;
        int res = 0;
        for(String s:operations){
            switch (s) {
                case "C" -> --index;
                case "D" -> {
                    nums[index] = nums[index - 1] * 2;
                    ++index;
                }
                case "+" -> {
                    nums[index] = (nums[index - 1] + nums[index - 2]);
                    ++index;
                }
                default -> {
                    nums[index] = Integer.parseInt(s);
                    ++index;
                }
            }
        }
        for(int i = 0;i<index;i++){
            res+=nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        S682 s682 = new S682();
        // 36 28 70 98 33 -46 =
        System.out.println(s682.calPoints(new String[]{"36","28","70","65","C","+","33","-46","84","C"}));
    }
}

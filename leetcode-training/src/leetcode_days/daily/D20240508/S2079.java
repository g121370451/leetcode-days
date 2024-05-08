package leetcode_days.daily.D20240508;

public class S2079 {
    public int wateringPlants(int[] plants, int capacity) {
        int res = 0;
        int currentCapacity = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (currentCapacity < plants[i]) {
                res += i * 2;
                currentCapacity = capacity;
            }
            res += 1;
            currentCapacity -= plants[i];
        }
        return res;
    }

    public static void main(String[] args) {
        S2079 s2079 = new S2079();
        int[] plants = {2, 2, 3, 3};
        int capacity = 5;
        System.out.println(s2079.wateringPlants(plants, capacity));
    }
}

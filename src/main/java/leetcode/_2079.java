package leetcode;

/**
 * @author chenxin
 * @since 2024/5/8 星期三 下午2:21
 */
public class _2079 {

    // 由于需要浇灌所有植物，至少要走 n 步，故初始化答案 ans=n。
    // 初始化水罐中的水量 water=capacity。
    // 从左到右遍历 plants。如果 water<plants[i]，那么我们在上一个位置 x=i−1 就可以返回 x=−1 重新灌满水，再返回到 x=i−1，需要额外走 2i 步，加入答案，把 water 重置为 capacity。然后浇水，把 water 减少 plants[i]。
    // 返回答案。
    public static void main(String[] args) {
        System.out.println("14: " + wateringPlants(new int[]{2, 2, 3, 3}, 5));

        System.out.println();

        System.out.println("30: " + wateringPlants(new int[]{1, 1, 1, 4, 2, 3}, 4));

        System.out.println();

        System.out.println("49: " + wateringPlants(new int[]{7, 7, 7, 7, 7, 7, 7}, 8));
    }

    public static int wateringPlants(int[] plants, int capacity) {

        int step = 0;
        int currentWater = capacity;
        int currentIndex = -1;

        while (currentIndex < plants.length - 1) {
            currentIndex++;

            currentWater -= plants[currentIndex];

            if (currentWater < 0) {
                step += ((currentIndex - 1) * 2) + 1;
                currentWater = capacity;
                currentIndex--;
            }

            step++;
        }
        return step;
    }

    public int wateringPlants1(int[] plants, int capacity) {
        int n = plants.length;
        int ans = n;
        int water = capacity;
        for (int i = 0; i < n; i++) {
            if (water < plants[i]) {
                ans += i * 2;
                water = capacity;
            }
            water -= plants[i];
        }
        return ans;
    }
}

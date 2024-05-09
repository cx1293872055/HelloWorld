package leetcode;

/**
 * @author chenxin
 * @since 2024/5/9 星期四 上午10:25
 */
public class _2105 {

    public static void main(String[] args) {

        System.out.println(minimumRefill(new int[]{2, 2, 3, 3}, 5, 5));
        System.out.println(minimumRefill(new int[]{2, 2, 3, 3}, 3, 4));
        System.out.println(minimumRefill(new int[]{5}, 10, 8));
        System.out.println(minimumRefill(new int[]{2, 1, 1}, 2, 2));

    }

    public static int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int count = 0;

        int aStart = 0;
        int aWater = capacityA;

        int bStart = plants.length - 1;
        int bWater = capacityB;

        while (aStart <= bStart) {
            if (aStart == bStart) {
                if (aWater == bWater || aWater > bWater) {
                    if (aWater < plants[aStart]) {
                        count++;
                    }
                } else {
                    if (bWater < plants[bStart]) {
                        count++;
                    }
                }
                break;
            }
            if (aWater < plants[aStart]) {
                count++;
                aWater = capacityA;
            }
            aWater -= plants[aStart++];
            if (bWater < plants[bStart]) {
                count++;
                bWater = capacityB;
            }
            bWater -= plants[bStart--];
        }
        return count;
    }
}

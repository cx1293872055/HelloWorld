package leetcode;

/**
 * @author chenxin
 * @since 2024/5/9 星期四 下午3:59
 */
public class _495 {

    public static void main(String[] args) {

        System.out.println(findPoisonedDuration(new int[]{1, 4}, 2));
        System.out.println(findPoisonedDuration(new int[]{1, 2}, 2));
        System.out.println(findPoisonedDuration(new int[]{1, 4, 10}, 3));
        System.out.println(findPoisonedDuration(new int[]{1, 2, 3, 4, 5}, 5));
        System.out.println(findPoisonedDuration(new int[]{0, 1, 2, 3, 4, 5}, 1));

    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {

        int lastSec = -1;
        int sumSec = 0;

        for (final int timeSery : timeSeries) {
            if (timeSery <= lastSec) {
                sumSec += duration - (lastSec - timeSery) - 1;
            } else {
                sumSec += duration;
            }
            lastSec = timeSery + duration - 1;
        }

        return sumSec;
    }
}

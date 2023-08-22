package leetcode;

/**
 * @author chenxin
 * @date 2023/8/22 星期二 16:31
 */
public class _849 {

    public static void main(String[] args) {
        System.out.println(maxDistToClosest(new int[]{1, 1, 0, 0, 0, 1, 0}));
    }

    public static int maxDistToClosest(int[] seats) {

        int index = 0;
        int maxGap;
        int preSeat;

        while (index < seats.length && seats[index] == 0) {
            index++;
        }

        preSeat = index;
        maxGap = index;

        while (index < seats.length) {
            int seat = seats[index];

            if (seat == 1) {
                maxGap = Math.max(maxGap, (index - preSeat) >> 1);
                preSeat = index;
            }
            index++;

        }

        if (seats[seats.length - 1] == 0) {
            maxGap = Math.max(seats.length - 1 - preSeat, maxGap);
        }

        return maxGap;
    }
}

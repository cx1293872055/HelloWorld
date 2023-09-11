package leetcode;

import java.util.Arrays;

/**
 * @author chenxin
 * @date 2023/8/28 星期一 19:15
 */
public class _57 {

    public static void main(String[] args) {
        //[[1,3],[6,9]]
        System.out.println(Arrays.deepToString(insert(new int[][]{{3, 5}}, new int[]{1, 2})));
    }


    public static int[][] insert(int[][] intervals, int[] newInterval) {

        int[][] result = new int[20000][2];

        int start = newInterval[0];
        int end = newInterval[1];

        int ind = 0;
        int resInd = 0;

        while (ind < intervals.length) {

            int[] newEle = new int[2];

            int[] ele = intervals[ind++];
            int ele0 = ele[0];
            int ele1 = ele[1];
            newEle[0] = ele0;
            newEle[1] = ele1;

            if (end < ele0) {
                newEle = newInterval;
                ind--;
            }
            if (ele0 <= start && start <= ele1) {
                while (ind < intervals.length) {
                    int[] tele = intervals[ind++];
                    int tele0 = tele[0];
                    int tele1 = tele[1];
                    if (tele0 > end) {
                        newEle[1] = end;
                        ind--;
                        break;
                    }
                    if (end <= tele1) {
                        newEle[1] = tele1;
                        break;
                    }
                }


                newEle[1] = Math.max(end, newEle[1]);
            }


            result[resInd++] = newEle;
        }

        if (result[0][0] == 0 && result[0][1] == 0) {
            result[resInd++] = newInterval;
        }

        return Arrays.copyOf(result, resInd);
    }
}

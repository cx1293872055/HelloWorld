package leetcode;

/**
 * @author chenxin
 * @since 2024/5/11 星期六 下午6:24
 */
public class _2391 {

    public static void main(String[] args) {
        System.out.println(garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3}));

    }

    public static int garbageCollection(String[] garbage, int[] travel) {
        char m = 'M', p = 'P', g = 'G';
        int mi = 0, pi = 0, gi = 0;

        int result = 0;
        for (int i = 0; i < garbage.length; i++) {
            for (final char c : garbage[i].toCharArray()) {
                if (m == c) {
                    for (int ii = mi; ii < i; ii++) {
                        result += travel[ii];
                    }
                    mi = i;
                    result++;
                }
                if (p == c) {
                    for (int ii = pi; ii < i; ii++) {
                        result += travel[ii];
                    }
                    pi = i;
                    result++;
                }
                if (g == c) {
                    for (int ii = gi; ii < i; ii++) {
                        result += travel[ii];
                    }
                    gi = i;
                    result++;
                }
            }
        }
        return result;
    }
}

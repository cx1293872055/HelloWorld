package leetcode;

/**
 * @author chenxin
 * @since 2024/6/11 星期二 下午6:36
 */
public class _389 {

    public static void main(String[] args) {
        System.out.println(findTheDifference("abd", "abcd"));

    }

    public static char findTheDifference(String s, String t) {

        char result = 0;

        for (final char c : s.toCharArray()) {
            result ^= c;
        }
        for (final char c : t.toCharArray()) {
            result ^= c;
        }
        return result;
    }
}

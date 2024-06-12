package leetcode;

/**
 * @author chenxin
 * @since 2024/6/12 星期三 下午6:07
 */
public class _459 {

    public static void main(String[] args) {

        System.out.println(repeatedSubstringPattern("abac"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        int m = s.length();
        int[] pi = new int[m];
        int j = 0;

        for (int i = 1; i < m; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pi[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }

        if (pi[m - 1] == 0) {
            return false;
        }
        return pi[m - 1] % (m - pi[m - 1]) == 0;
    }
}

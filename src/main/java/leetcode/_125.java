package leetcode;

/**
 * @author chenxin
 * @since 2024/6/7 星期五 下午5:14
 */
public class _125 {

    public static void main(String[] args) {
        // System.out.println(isPalindrome("0P"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        int len = s.length();

        int start = 0;
        int end = s.length() - 1;

        do {
            while (start < len && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (end > 0 && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if (start < len && end > 0 && Character.toLowerCase(s.charAt(start++)) != Character.toLowerCase(s.charAt(end--))) {
                return false;
            }
        } while (start < end);

        return true;
    }
}

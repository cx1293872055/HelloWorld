package leetcode;

/**
 * @author chenxin
 * @since 2024/6/12 星期三 下午6:46
 */
public class _482 {

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
        System.out.println(licenseKeyFormatting("---a-a-a-a---", 2));

    }

    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int len = s.toCharArray().length;
        int count = 0;
        for (int j = len - 1; j >= 0; j--) {
            char c = s.charAt(j);
            if (c != '-') {
                if (count == k) {
                    sb.append('-');
                    count = 0;
                }
                sb.append(Character.toUpperCase(c));
                count++;
            }
        }
        return sb.reverse().toString();
    }
}

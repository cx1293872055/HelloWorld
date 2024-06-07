package leetcode;

/**
 * @author chenxin
 * @since 2024/6/7 星期五 下午3:55
 */
public class _67 {

    public static void main(String[] args) {
        System.out.println(addBinary("101010","10101"));

    }

    public static String addBinary(String a, String b) {

        StringBuffer sb = new StringBuffer();

        int maxLen = Math.max(a.length(), b.length());

        int tempValue = 0;

        for (int i = 0; i < maxLen; i++) {
            tempValue += i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
            tempValue += i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
            sb.append(tempValue % 2);

            tempValue /= 2;
        }
        if (tempValue > 0) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }
}

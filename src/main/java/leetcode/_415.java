package leetcode;

/**
 * @author chenxin
 * @since 2024/6/11 星期二 下午6:42
 */
public class _415 {

    public static void main(String[] args) {
        System.out.println(addStrings("99","9999999"));
    }

    public static String addStrings(String num1, String num2) {

        StringBuffer sb = new StringBuffer();

        int maxLen = Math.max(num1.length(), num2.length());

        int tempValue = 0;

        for (int i = 0; i < maxLen; i++) {
            tempValue += i < num1.length() ? num1.charAt(num1.length() - 1 - i) - '0' : 0;
            tempValue += i < num2.length() ? num2.charAt(num2.length() - 1 - i) - '0' : 0;
            sb.append(tempValue % 10);

            tempValue /= 10;
        }
        if (tempValue > 0) {
            sb.append(tempValue);
        }

        return sb.reverse().toString();
    }
}

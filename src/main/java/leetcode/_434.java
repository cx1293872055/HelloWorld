package leetcode;

/**
 * @author chenxin
 * @since 2024/6/11 星期二 下午6:49
 */
public class _434 {

    public static void main(String[] args) {
        System.out.println(countSegments("hello, my name is John"));

    }

    public static int countSegments(String s) {
        int count = 0;
        s = s.trim();

        if (s.isEmpty()) {
            return 0;
        }
        for (int i = 1; i < s.toCharArray().length; i++) {
            if ((s.charAt(i) != ' ' && s.charAt(i - 1) == ' ')
                    || (s.charAt(i) == ' ' && s.charAt(i - 1) != ' ')) {
                count++;
            }
        }

        return (count / 2) + 1;
    }
}

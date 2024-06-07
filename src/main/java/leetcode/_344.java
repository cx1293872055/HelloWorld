package leetcode;

/**
 * @author chenxin
 * @since 2024/6/7 星期五 下午5:47
 */
public class _344 {

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o','a'};
        reverseString(s);
        System.out.println(s);

    }

    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            swap(s, start++, end--);
        }
    }

    public static void swap(char[] c, int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
}

package leetcode;

/**
 * @author chenxin
 * @since 2024/6/7 星期五 下午3:26
 */
public class _58 {

    public static void main(String[] args) {

        System.out.println(lengthOfLastWord("   hello world "));
    }

    public static int lengthOfLastWord(String s) {
        int len = 0;
        char[] charArray = s.toCharArray();
        int index = charArray.length - 1;
        while (charArray[index] == ' ') {
            index--;
        }

        while (index >=0 && charArray[index] != ' ') {
            index--;
            len++;
        }

        return len;
    }
}

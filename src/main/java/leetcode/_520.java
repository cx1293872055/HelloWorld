package leetcode;

/**
 * @author chenxin
 * @since 2024/6/14 星期五 下午6:10
 */
public class _520 {

    public static void main(String[] args) {

    }

    /**
     * 更好的方式
     * 统计大写字母个数
     *
     * if(count == len || count == 0 || (isUpper(word[0]) && count == 1)) return true
     *
     * @param word
     * @return
     */

    public static boolean detectCapitalUse(String word) {
        if (word.length() > 1 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        }
        for (int i = 2; i < word.toCharArray().length; i++) {
            if (Character.isUpperCase(word.charAt(i)) != Character.isUpperCase(word.charAt(1))) {
                return false;
            }
        }
        return true;
    }
}

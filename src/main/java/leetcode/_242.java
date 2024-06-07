package leetcode;

import java.util.Arrays;

/**
 * @author chenxin
 * @since 2024/6/7 星期五 下午5:42
 */
public class _242 {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));

    }

    public static boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return new String(sChars).equals(new String(tChars));
    }
}

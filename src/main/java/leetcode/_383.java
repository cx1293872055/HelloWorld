package leetcode;

/**
 * @author chenxin
 * @since 2024/6/11 星期二 下午6:30
 */
public class _383{

    public static void main(String[] args) {

    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];

        for (final char c : ransomNote.toCharArray()) {
            letters[c - 'a']++;
        }

        for (final char c : magazine.toCharArray()) {
            letters[c - 'a']--;
        }

        for (final int letter : letters) {
            if (letter > 0) {
                return false;
            }
        }

        return true;
    }
}

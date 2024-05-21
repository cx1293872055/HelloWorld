package leetcode;

/**
 * @author chenxin
 * @since 2024/5/21 星期二 下午6:21
 */
public class _2769 {

    public static void main(String[] args) {
        System.out.println(theMaximumAchievableX(4, 1));
    }

    public static int theMaximumAchievableX(int num, int t) {
        return num + 2 * t;
    }
}

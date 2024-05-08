package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxin
 * @since 2024/5/8 星期三 下午5:48
 */
public class _119 {

    public static void main(String[] args) {
        System.out.println(getRow(2));
        System.out.println(getRow(3));
        System.out.println(getRow(4));
        System.out.println(getRow(5));
        System.out.println(getRow(30));

    }

    public static List<Integer> getRow(int rowIndex) {

        List<Integer> result = new ArrayList<>();
        result.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            result.add((int) ((long) result.get(i - 1) * (rowIndex - i + 1) / i));
        }

        return result;
    }
}

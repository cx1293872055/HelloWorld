package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxin
 * @since 2024/6/11 星期二 下午6:39
 */
public class _412 {

    public static void main(String[] args) {

    }

    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }
}

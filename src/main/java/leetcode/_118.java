package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chenxin
 * @since 2024/5/8 星期三 下午5:34
 */
public class _118 {

    // 杨辉三角形
    public static void main(String[] args) {

        System.out.println(generate(5));

    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(1));


        for (int i = 1; i < numRows; i++) {
            List<Integer> currentList = new ArrayList<>();
            currentList.add(1);

            for (int j = 1; j < i; j++) {
                List<Integer> upList = result.get(i - 1);
                currentList.add(upList.get(j - 1) + upList.get(j));
            }

            currentList.add(1);
            result.add(currentList);
        }

        return result;
    }
}

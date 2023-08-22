package leetcode;

/**
 * @author chenxin
 * @date 2023/8/21 星期一 13:40
 */
public class _2337 {

    public static void main(String[] args) {

        String start = "____";
        String target = "R_L_";

        System.out.println(canChange(start, target));
    }

    /**
     * 每次找到start、target中不为_的字符
     * 比较，
     * 若不相同，那么false
     * 若相同，那么比较字符下标是否能够通过移动得到target
     *
     */

    public static boolean canChange(String start, String target) {

        if (start.length() == target.length() && start.isEmpty()) {
            return true;
        }

        char _c = '_';
        char L = 'L';
        char R = 'R';

        int startIndex = 0;

        for (int targetIndex = 0; targetIndex < target.length(); ) {

            char currentChar = target.charAt(targetIndex);

            if (currentChar == _c) {
                targetIndex++;
                continue;
            }


            while (true) {
                if (startIndex >= start.length()) {
                    return false;
                }
                char startCurrentChar = start.charAt(startIndex++);

                if (startCurrentChar == _c) {
                    continue;
                }

                if (currentChar != startCurrentChar) {
                    return false;
                }

                if (targetIndex + 1 <= startIndex) {
                    targetIndex++;
                    break;
                } else {
                    return false;
                }
            }

            if (currentChar == L) {
                while (true) {
                    if (startIndex >= start.length()) {
                        return false;
                    }
                    char startCurrentChar = start.charAt(startIndex++);

                    if (startCurrentChar == _c) {
                        continue;
                    }

                    if (startCurrentChar == R) {
                        return false;
                    }

                    if (targetIndex + 1 <= startIndex) {
                        targetIndex++;
                        break;
                    } else {
                        return false;
                    }
                }
            }

            if (currentChar == R) {
                while (true) {
                    if (startIndex >= start.length()) {
                        return false;
                    }
                    char startCurrentChar = start.charAt(startIndex++);


                    if (startCurrentChar == _c) {
                        continue;
                    }

                    if (startCurrentChar == L) {
                        return false;
                    }

                    if (targetIndex + 1 >= startIndex) {
                        targetIndex++;
                        break;
                    } else {
                        return false;
                    }
                }
            }

        }
        while (startIndex < start.length()) {
            if (start.charAt(startIndex++) != _c) {
                return false;
            }
        }
        return true;
    }

    public boolean fastest_canChange(String start, String target) {
        char[] cs1 = start.toCharArray();
        char[] cs2 = target.toCharArray();
        int len = cs1.length, i = 0, j = 0;
        while(i < len || j < len){
            while(i < len && cs1[i] == '_')
                i++;
            while(j < len && cs2[j] == '_')
                j++;

            if(i == len || j == len)
                return i == j;
            if(cs1[i] != cs2[j])
                return false;
            if(cs1[i] == 'L' && i < j)
                return false;
            if(cs1[i] == 'R' && i > j)
                return false;
            i++;
            j++;
        }
        return i == j;
    }

}

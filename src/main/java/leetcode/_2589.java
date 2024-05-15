package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author chenxin
 * @since 2024/5/15 星期三 上午10:23
 */
public class _2589 {

    public static void main(String[] args) {

        // System.out.println(findMinimumTime3(new int[][]{{2, 13, 2}, {6, 18, 5}, {2, 13, 3}}));
        System.out.println(findMinimumTime3(new int[][]{{2, 13, 2}, {6, 18, 5}, {2, 13, 3}, {18, 20, 2}, {12, 30, 6}}));
        // System.out.println(findMinimumTime(new int[][]{{2, 3, 1}, {4, 5, 1}, {1, 5, 2}}));
        // System.out.println(findMinimumTime(new int[][]{{1, 1, 1}}));
        // System.out.println(findMinimumTime1(new int[][]{{1, 1, 1}}));

    }

    public static int findMinimumTime(int[][] tasks) {

        int n = tasks.length;

        Arrays.sort(tasks, Comparator.comparingInt(a -> a[1]));
        int[] ints = new int[tasks[n - 1][1] + 1];

        int count = 0;

        for (final int[] task : tasks) {
            int start = task[0];
            int end = task[1];
            int duration = task[2];

            while (start <= end) {
                if (ints[start++] == 1) {
                    duration--;
                }
            }

            while (duration > 0 && end >= task[0]) {
                if (ints[end] == 0) {
                    count++;
                    ints[end] = 1;
                    duration--;
                }
                end--;
            }
        }
        return count;
    }

    /**
     * 查找最短时间1
     * 贪心 + 扫描线
     *
     * @param tasks 任务
     * @return int
     */
    public static int findMinimumTime1(int[][] tasks) {
        int count = 0;

        for (int i = 1; ; i++) {

            boolean finish = true;
            boolean scan = false;

            for (final int[] task : tasks) {
                // 如果存在一个区间是当前任务必须在其中运行
                // 则标记扫描到目标

                // 因为每一次扫描到目标后,都会将目标覆盖的任务时间递减
                // 所以不会漏掉
                if (task[1] - i + 1 == task[2]) {
                    scan = true;
                }

                // 如果存在有一个任务还在扫描区间内则不结束扫描
                if (task[1] >= i) {
                    finish = false;
                }
            }

            if (finish) {
                break;
            }

            // 在有目标的前提下
            // 将所有包含当前目标时间的任务的时间都减1(任务时间>0 减1)
            if (scan) {
                for (final int[] task : tasks) {
                    if (task[0] < i && i < task[1] && task[2] != 0) {
                        task[2]--;
                    }
                }
                count++;
            }
        }
        return count;
    }

    /**
     * 查找最短时间3
     * 贪心 + 二分查找 + 栈
     *
     * @param tasks 任务
     * @return int
     */
    public static int findMinimumTime3(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[1]));
        List<int[]> stack = new ArrayList<>();
        stack.add(new int[]{-1, -1, 0});
        for (int[] task : tasks) {
            int start = task[0], end = task[1], duration = task[2];

            // 二分查找 找到开始时间 在运行时间区间的下标+1
            int k = binarySearch(stack, start);

            // 当前任务的需要时间减去 (最后的一个运行区间的时间 - 找到的运行区间的时间)
            // 为什么呢?
            // 因为依据结束时间排序之后,运行区间的最后一个区间的结束时间一定 <= 当前的结束时间
            // 减去的值是 找到区间到最后一个区间之间的可运行时间(不包含 找到区间的运行时间)
            duration -= stack.get(stack.size() - 1)[2] - stack.get(k - 1)[2];

            // 如果当前开始时间小于等于找到运行区间的结束时间
            // 当前任务的需要时间再减去 (找到运行区间的结束时间 - 当前任务的开始时间 + 1)
            // 为什么呢?
            // 因为上一步只是减去了 找到区间到最后区间的可用时间(不包含找到区间内的时间)
            // 所以需要得出找到区间中可运行的时间

            // 这里的判断是过滤初始区间
            if (start <= stack.get(k - 1)[1]) {
                duration -= stack.get(k - 1)[1] - start + 1;
            }

            // 当前任务需要时间 <= 0
            // 说明当前任务已经可以在正在运行的区间内执行
            // 所以跳到下一个任务
            if (duration <= 0) {
                continue;
            }

            // 如果走到这里还有时间需要运行
            // 那么判断当前任务的区间是否和最后一个运行区间有重叠

            // 如果当前任务的结束时间 - 最后一个区间的结束时间 <= 剩下的时间
            // 那么说明当前任务的区间可以和最后一个区间连接,
            // 故将最后一个区间的运行时间算在剩下的时间内,然后把最后一个区间去除
            // 直到最后一个区间和当前任务不存在重叠时

            // 如果不是,那么说明当前任务需要一个单独的区间

            // 循环结束后,剩下时间应该是,从当前任务向前,所有能够连接起来的区间的时间和
            while (end - stack.get(stack.size() - 1)[1] <= duration) {
                duration += stack.get(stack.size() - 1)[1] - stack.get(stack.size() - 1)[0] + 1;
                stack.remove(stack.size() - 1);
            }

            // 由当前任务的结束时间和剩余的时间计算出运行区间的开始时间,
            // 并且把运行区间的最后一个区间的时间加到当前的任务时间内得到运行到当前任务所需要的最短的时间
            stack.add(new int[]{end - duration + 1, end, stack.get(stack.size() - 1)[2] + duration});
        }
        // 取区间的最后一个区间的时间,即是运行所有任务所需要的最小时间
        return stack.get(stack.size() - 1)[2];
    }

    public static int binarySearch(List<int[]> stack, int target) {
        int low = 0, high = stack.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (stack.get(mid)[0] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}

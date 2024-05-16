package leetcode;

/**
 * @author chenxin
 * @since 2024/5/16 星期四 上午11:37
 */
public class _1953 {

    public static void main(String[] args) {
        System.out.println(numberOfWeeks(new int[]{1, 2, 3}));
    }

    // 方法一：贪心
    // 提示 1
    // 考虑耗时最长的工作。假设我们需要 longest 周完成该工作，其余工作共计需要 rest 周完成。那么可以完成所有工作的充要条件是： longest≤rest+1.

    // 提示 1 解释
    // 首先考虑必要性。必要性可以通过证明逆否命题，即「如果 longest>rest+1，那么无法完成所有的工作」，来证明。
    // 我们可以利用反证法，如果可以完成所有工作，那么耗时最长的工作一定可以完成，这意味着至少需要有 longest−1 周剩余工作可以被分配在间隔内，但剩余工作的工时 rest 并不满足这一要求，因此充分性得证。
    // 随后考虑充分性。充分性可以通过构造分配方案来证明。我们可以将分配工作时间的过程转化为在 [1,longest+rest] 闭区间内分配整数的过程，其中每个整数代表对应的一周时间。在分配整数的过程中，我们首先按照从小到大的顺序分配所有的奇数，然后按照从小到大的顺序分配所有的偶数。
    // 我们将所有工作按照耗时从高到低来排序，按照前文的顺序分配对应的时间。此时由于 longest≤rest+1，因此耗时最长的工作不会出现任意两周相邻这种违反规定的情况。类似地可以证明，其他工作由于耗时小于最长的工作，也不会出现相邻的情况。因此必要性得证。

    // 思路与算法
    // 根据 提示 1，我们首先计算出耗时最长的工作所需周数 longest 与剩余工作所需周数 rest，并比较两者大小。根据比较的结果不同会有两种情况：
    // longest≤rest+1，此时根据 提示 1，所有工作都可以完成，我们返回所有工作的总耗时 longest+rest 作为答案。
    // longest>rest+1，此时我们无法完成耗时最长的工作。根据 提示 1 的证明过程，耗时最长的工作最多可以完成 rest+1 周，因此最大的工作周数即为 2×rest+1，我们返回该数作为答案。
    // 最后，由于 rest 可能超过 32 位整数的范围，我们需要使用 64 位整数进行相应的计算与比较。
    public static long numberOfWeeks(int[] milestones) {

        long max = 0;
        long rest = 0;

        for (final int milestone : milestones) {
            max = Math.max(milestone, max);
            rest += milestone;
        }

        rest -= max;

        if (max > rest) {
            return rest * 2 + 1;
        } else {
            return max + rest;
        }
    }
}

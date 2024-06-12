package leetcode;

/**
 * @author chenxin
 * @since 2024/6/12 星期三 下午5:18
 */
public class _2806 {

    public static void main(String[] args) {

        System.out.println(accountBalanceAfterPurchase(9));
        System.out.println(accountBalanceAfterPurchase(10));
        System.out.println(accountBalanceAfterPurchase(15));

    }

    public static int accountBalanceAfterPurchase(int purchaseAmount) {
        return 100 - (((purchaseAmount + 5) / 10) * 10);
    }
}

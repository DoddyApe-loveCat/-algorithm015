package homework;

/**
 * @author sunzhiqiang
 * @date 2020/10/11 3:37 下午
 * @description 零钱兑换II
 */
public class Change {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            //每一个硬币对当前amount的组合数
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}

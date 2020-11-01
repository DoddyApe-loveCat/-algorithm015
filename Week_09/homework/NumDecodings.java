package homework;

/**
 * @author sunzhiqiang
 * @date 2020/11/1 11:49 下午
 */
public class NumDecodings {
    public int numDecodings(String s) {
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[length] = 1;
        for (int i = length - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            dp[i] = dp[i + 1];
            if (i < length - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }
}

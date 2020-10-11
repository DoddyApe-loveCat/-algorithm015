package homework;

/**
 * @author sunzhiqiang
 * @date 2020/10/11 2:12 下午
 * @description 解码方法
 */
public class NumDecoding {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            dp[i] = dp[i + 1];
            if (i < s.length() - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }
}

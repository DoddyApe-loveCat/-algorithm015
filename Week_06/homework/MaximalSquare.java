package homework;

/**
 * @author sunzhiqiang
 * @date 2020/10/11 2:10 下午
 * @description 最大正方形
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int result = 0;
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '0') continue;
                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                result = Math.max(result, dp[i][j]);
            }
        }
        return result * result;
    }
}

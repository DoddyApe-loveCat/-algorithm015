package homework;

/**
 * @author sunzhiqiang25
 * @date 2020/10/26 12:37 上午
 * @department 企业效率组
 * @description 描述
 */
public class ReverseBit {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = (ans << 1) + (n & 1);
            n = n >> 1;
        }
        return ans;
    }
}

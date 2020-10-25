package homework;

/**
 * @author sunzhiqiang
 * @date 2020/10/26 12:36 上午
 */
public class Bit1 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}

package homework;

/**
 * @author sunzhiqiang2
 * @date 2020/8/30 4:29 下午
 * @description 旋转数组
 */
public class RotateArray {
    /**
     * 旋转数组解法一
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }

    /**
     * 旋转数组解法二
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int count = 0;
        for (int start = 0; count < nums.length; ++start) {
            int current = start;
            int pre = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                current = next;
                count++;
            } while (current != start);
        }
    }
}

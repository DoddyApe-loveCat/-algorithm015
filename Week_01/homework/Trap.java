package homework;

import java.util.Stack;

/**
 * @author sunzhiqiang
 * @description 接雨水
 */
public class Trap {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack();
        int ans = 0;
        for (int i = 0; i<height.length; ++i) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
               int low = stack.pop();
               if (stack.isEmpty()) break;
               int minHeight = Math.min(height[i], height[stack.peek()]) - height[low];
               ans = ans + minHeight * (i-stack.peek()-1);
            }
            stack.push(i);
        }
        return ans;
    }
}
package homework;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列I
 */
public class PermutationNoRepeat {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, 0, path, used, res);
        return res;
    }
    private void backtrack(int[] nums, int begin, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i<nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                backtrack(nums, i + 1, path, used, res);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}

package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集II
 */
public class SubSetRepeat {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, path, res);
        return res;
    }
    private void dfs(int[] nums, int begin, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = begin; i < nums.length; i++) {
            if (i>begin && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            dfs(nums, i+1, path, res);
            path.remove(path.size() - 1);
        }
    }
}

package homework;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集I
 */
public class SubSetNoRepeat {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path, res);
        return res;
    }
    private void dfs(int[] nums, int begin, List<Integer> path, List<List<Integer>> res) {
        if (begin == nums.length) {
            res.add(new ArrayList(path));
            return;
        }
        dfs(nums, begin +1, path, res);
        path.add(nums[begin]);
        dfs(nums, begin + 1, path, res);
        path.remove(path.size() - 1);
    }
}

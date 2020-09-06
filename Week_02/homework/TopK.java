package homework;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author sunzhiqiang
 * @date 2020/9/6 11:45 下午
 */
public class TopK {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length; i++) {
            if(!map.containsKey(nums[i])) map.put(nums[i], 0);
            map.put(nums[i], map.get(nums[i])+1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        map.forEach((key, v) ->{
            if (queue.size() < k){
                queue.add(key);
            } else if (map.get(queue.peek()) < v) {
                queue.remove();
                queue.add(key);
            }
        });
        int[] res = new int[k];
        for (int i = k-1; i>=0; i--) {
            res[i] = queue.poll();
        }
        return res;
    }
}

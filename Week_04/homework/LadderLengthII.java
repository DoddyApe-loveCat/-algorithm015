package homework;

import java.util.*;

/**
 * @author sunzhiqiang
 * @date 2020/9/20 9:37 下午
 * @description 单词接龙II 双端广度优先搜索
 */
public class LadderLengthII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dictionary = new HashSet<>(wordList);
        if (!dictionary.contains(endWord)) return res;
        Map<String, List<String>> nodeNeighbors = getChildren(beginWord, endWord, dictionary);
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        findLadders(beginWord, endWord, nodeNeighbors, path, res);
        return res;
    }

    private Map<String, List<String>> getChildren(String beginWord, String endWord, Set<String> dictionary) {
        Map<String, List<String>> map = new HashMap<>();
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> visited = new HashSet<>();
        start.add(beginWord);
        end.add(endWord);
        boolean found = false;
        boolean isBackward = false;
        while (!start.isEmpty() && !found) {
            if (start.size() > end.size()) {
                Set<String> temp = new HashSet<>();
                temp = start;
                start = end;
                end = temp;
                isBackward = !isBackward;
            }
            Set<String> next = new HashSet<>();
            for (String node : start) {
                visited.add(node);
                for (String neighbor : getNext(node, dictionary)) {
                    if (visited.contains(neighbor) || start.contains(neighbor)) continue;
                    if (end.contains(neighbor)) found = true;
                    next.add(neighbor);
                    String parent = isBackward ? neighbor : node;
                    String child = isBackward ? node : neighbor;
                    if (!map.containsKey(parent)) map.put(parent, new ArrayList<>());
                    map.get(parent).add(child);
                }
            }
            start = next;
        }
        return map;
    }

    private List<String> getNext(String cur, Set<String> dictionary) {
        List<String> res = new ArrayList<>();
        char[] array = cur.toCharArray();
        for (int i = 0; i < cur.length(); i++) {
            char old = array[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == array[i]) continue;
                array[i] = c;
                String str = String.valueOf(array);
                if (dictionary.contains(str)) res.add(str);
            }
            array[i] = old;
        }
        return res;
    }

    private void findLadders(String beginWord, String endWord, Map<String, List<String>> nodeNeighbors, List<String> path, List<List<String>> res) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (!nodeNeighbors.containsKey(beginWord)) return;
        for (String node : nodeNeighbors.get(beginWord)) {
            path.add(node);
            findLadders(node, endWord, nodeNeighbors, path, res);
            path.remove(path.size() - 1);
        }
    }
}

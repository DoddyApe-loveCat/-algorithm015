package homework;

import java.util.*;

/**
 * @author sunzhiqiang
 * @date 2020/10/18 2:55 下午
 * @description 单词接龙II 双向搜索
 */
public class LetterFollowII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!dictionary.contains(endWord)) return res;
        Map<String, List<String>> nodeNeighbors = getNeighbors(beginWord, endWord, dictionary);
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        findLadders(beginWord, endWord, nodeNeighbors, path, res);
        return res;
    }

    private Map<String, List<String>> getNeighbors(String beginWord, String endWord, Set<String> dictionary) {
        Map<String, List<String>> map = new HashMap<>();
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> visited = new HashSet<>();
        start.add(beginWord);
        end.add(endWord);
        visited.add(beginWord);
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
            for (String s : start) {
                visited.add(s);
                for (String neighbor : getNext(s, dictionary)) {
                    if (start.contains(neighbor) || visited.contains(neighbor)) continue;
                    if (end.contains(neighbor)) found = true;
                    next.add(neighbor);
                    String parent = isBackward ? neighbor : s;
                    String child = isBackward ? s : neighbor;
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
                array[i] = c;
                String str = String.valueOf(array);
                if (dictionary.contains(str)) {
                    res.add(str);
                }
            }
            array[i] = old;
        }
        return res;

    }

    private void findLadders(String beginWord, String endWord, Map<String, List<String>> map, List<String> path, List<List<String>> res) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (!map.containsKey(beginWord)) return;
        for (String s : map.get(beginWord)) {
            path.add(s);
            findLadders(s, endWord, map, path, res);
            path.remove(path.size() - 1);
        }
    }
}

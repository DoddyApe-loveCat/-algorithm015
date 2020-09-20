package homework;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sunzhiqiang
 * @date 2020/9/20 9:35 下午
 * @description 单词接龙I
 */
public class LadderLengthI {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> directory = new HashSet<>(wordList);
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();
        if (!directory.contains(endWord)) return 0;
        start.add(beginWord);
        end.add(endWord);
        directory.remove(beginWord);
        directory.remove(endWord);
        int length = 1;
        while (!start.isEmpty()) {
            Set<String> next = new HashSet<>();
            for (String s : start) {
                char[] array = s.toCharArray();
                for (int i = 0; i < array.length; i++) {
                    char old = array[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        array[i] = c;
                        String str = String.valueOf(array);
                        if (end.contains(str)) return length + 1;
                        if (directory.contains(str)) {
                            next.add(str);
                            directory.remove(str);
                        }
                    }
                    array[i] = old;
                }
            }
            start = next.size() < end.size() ? next : end;
            end = start.size() == end.size() ? next : end;
            length++;
        }
        return 0;
    }
}

package homework;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sunzhiqiang
 * @date 2020/10/18 2:55 下午
 * @description 单词接龙I
 */
public class LetterFollowI {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dir = new HashSet<>(wordList);
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        if (!dir.contains(endWord)) return 0;
        begin.add(beginWord);
        end.add(endWord);
        dir.remove(beginWord);
        dir.remove(endWord);
        int length = 1;
        while (!begin.isEmpty()) {
            Set<String> next = new HashSet<>();
            for (String s : begin) {
                char[] array = s.toCharArray();
                for (int i = 0; i < array.length; i++) {
                    char old = array[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        array[i] = c;
                        String str = String.valueOf(array);
                        if (end.contains(str)) return length + 1;
                        if (dir.contains(str)) {
                            next.add(str);
                            dir.remove(str);
                        }
                    }
                    array[i] = old;
                }
            }
            begin = next.size() < end.size() ? next : end;
            end = begin.size() == end.size() ? next : end;
            length++;
        }
        return 0;
    }
}

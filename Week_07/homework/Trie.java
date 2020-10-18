package homework;

/**
 * @author sunzhiqiang
 * @date 2020/10/18 2:55 下午
 * @description
 */
public class Trie {
    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] array = word.toCharArray();
        TrieNode cur = root;
        for (char c : array) {
            int index = c - 'a';
            if (cur.children[index] == null) cur.children[index] = new TrieNode();
            cur = cur.children[index];
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] array = word.toCharArray();
        TrieNode cur = root;
        for (char c : array) {
            int index = c - 'a';
            if (cur.children[index] == null) return false;
            cur = cur.children[index];
        }
        return cur.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] array = prefix.toCharArray();
        TrieNode cur = root;
        for (char c : array) {
            int index = c - 'a';
            if (cur.children[index] == null) return false;
            cur = cur.children[index];
        }
        return true;
    }
}
class TrieNode{
    public TrieNode[] children = new TrieNode[26];
    public boolean isWord;
    public TrieNode(){}
}

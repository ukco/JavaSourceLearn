package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2021/4/14 10:33
 * @Version 1.0
 * @Description 208. 实现Trie（前缀树）
 */
public class Trie {

    private Trie[] children;

    private boolean isEnd;

    /**
     * Trie，又称前缀树或字典树
     */
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) { node.children[index] = new Trie(); }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) { return null; }
            node = node.children[index];
        }
        return node;
    }
}

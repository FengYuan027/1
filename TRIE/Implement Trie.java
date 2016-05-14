class TrieNode {
    // Initialize your data structure here.
    public TrieNode[] successors;
    public boolean end;
    public TrieNode() {
        successors = new TrieNode[26];
        end = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.successors[index] == null) node.successors[index] = new TrieNode();
            node = node.successors[index];
        }
        node.end = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = searchHelper(word);
        return node != null && node.end;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = searchHelper(prefix);
        return node != null;
    }
    
    public TrieNode searchHelper(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.successors[index] == null) return null;
            node = node.successors[index];
        }
        return node;
    }
}

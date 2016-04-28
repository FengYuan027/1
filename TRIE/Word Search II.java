public class Solution1 {
    private int[] directions = {-1, 0, 1, 0, -1};
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> hits = new ArrayList<String>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) return hits;
        int M = board.length, N = board[0].length;
        TrieNode root = new TrieNode();
        for (String word : words) root.insert(word.toCharArray(), 0);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (root.nodes[board[i][j] - 'a'] != null) search(board, root, i, j, M, N, hits);
            }
        }
        return hits;
    }
    
    private void search(char[][] board, TrieNode root, int x, int y, int M, int N, List<String> hits) {
        int offset = board[x][y] - 'a';
        if (offset < 0 || offset >= 26 || root.nodes[offset] == null) return;
        if (root.nodes[offset].end && !root.nodes[offset].found){
            hits.add(root.nodes[offset].word);
            root.nodes[offset].found = true;
        }
        board[x][y] ^= 256;
        for (int i = 0; i < directions.length - 1; i++) {
            int _x = x + directions[i], _y = y + directions[i+1];
            if (_x >= 0 && _x < M && _y >= 0 && _y < N) search(board, root.nodes[offset], _x, _y, M, N, hits);
        }
        board[x][y] ^= 256;
    }
    
    public class TrieNode {
        public TrieNode[] nodes = new TrieNode[26];
        public boolean end = false;
        public String word = null;
        public boolean found = false;
        
        public void insert(char[] _word, int index) {
            if (index == _word.length) {
                end = true;
                word = new String(_word);
                return;
            }
            int offset = _word[index] - 'a';
            if (nodes[offset] == null) nodes[offset] = new TrieNode();
            nodes[offset].insert(_word, index+1);
        }
    }
}

public class Solution2 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }
    
    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if(c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if(p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }
    
        board[i][j] = '#';
        if(i > 0) dfs(board, i - 1, j ,p, res); 
        if(j > 0) dfs(board, i, j - 1, p, res);
        if(i < board.length - 1) dfs(board, i + 1, j, p, res); 
        if(j < board[0].length - 1) dfs(board, i, j + 1, p, res); 
        board[i][j] = c;
    }
    
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String w : words) {
            TrieNode p = root;
            for(char c : w.toCharArray()) {
                int i = c - 'a';
                if(p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
           }
           p.word = w;
        }
        return root;
    }
    
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}

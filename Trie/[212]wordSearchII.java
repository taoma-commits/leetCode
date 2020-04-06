class Solution {
    class TrieNode {
        public Map<Character, TrieNode> children = new HashMap<>();
        public String word = null;
    }

    private char[][] BOARD = null; // note 1
    private int rows, cols = 0;
    private List<String> res = new ArrayList<>(); // note 2

    public List<String> findWords(char[][] board, String[] words) {
        BOARD = board;
        rows = board.length;
        cols = board[0].length;
        // Construct the Trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            node.word = word; // note 3
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (root.children.containsKey(board[i][j])) {
                    findWords(i, j, root);
                }
            }
        }
        return res;
    }

    private void findWords(int i, int j, TrieNode parent) {
        char c = BOARD[i][j];
        TrieNode child = parent.children.get(c);

        if (child.word != null) {
            res.add(child.word);
            child.word = null; // note 4: avoid duplicates.
        }
        BOARD[i][j] = '#'; // note 5: avoid reuse of the character.

        if (i < rows - 1) {
            if (child.children.containsKey(BOARD[i + 1][j])) {
                findWords(i + 1, j, child);
            }
        }
        if (i > 0) {
            if (child.children.containsKey(BOARD[i - 1][j])) {
                findWords(i - 1, j, child);
            }
        }
        if (j < cols - 1) {
            if (child.children.containsKey(BOARD[i][j + 1])) {
                findWords(i, j + 1, child);
            }
        }
        if (j > 0) {
            if (child.children.containsKey(BOARD[i][j - 1])) {
                findWords(i, j - 1, child);
            }
        }

        BOARD[i][j] = c; // note 6: restore after the search based on (i, j)-entry
        if (child.children.isEmpty()) { // note 7: prune branches
            parent.children.remove(c);
        }
    }
}

/**
 * performance: 25 ms < 55.76%, 48.6 MB < 29.69%
 * notes:
 * tag: backtracking, DFS. 
 */

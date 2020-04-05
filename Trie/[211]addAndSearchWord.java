class WordDictionary {
    class TrieNode {
        public Map<Character, TrieNode> children = new HashMap<>();
        public boolean isWord = false;
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] arr = word.toCharArray();
        TrieNode currentNode = root;
        for (char c : arr) {
            if (!currentNode.children.containsKey(c)) {
                currentNode.children.put(c, new TrieNode());
            }
            currentNode = currentNode.children.get(c);
        }
        currentNode.isWord = true;
    }

    public boolean search(String word, int idx, TrieNode node) {
        if (idx == word.length()) {
            return node.isWord;
        }
        // if (node.children.isEmpty()) {
        //     return false;
        // }
        char c = word.charAt(idx);
        if (node.children.containsKey(c)) {
            return search(word, idx + 1, node.children.get(c));
        } else if (c == '.') {
            for (char key : node.children.keySet()) {
                if (search(word, idx + 1, node.children.get(key))) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, 0, root);
    }
}

/**
 * performance: 73 ms < 44%, 50.1 MB < 100%
 */

class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode();
        for (String str : dict) {
            TrieNode node = root;
            for (char c : str.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = str;
        }
        String[] arr = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : arr) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                TrieNode child = node.children[c - 'a'];
                if (child == null || node.word != null) {
                    break;
                }
                node = child;
            }
            sb.append(node.word == null ? word : node.word);
        }
        return sb.toString();
    }
}

/**
 * performance: 10 ms < 96%, 50 MB < 42%
 * notes: 1. take the Trie of roots not words in the sentence
 *        2. a word could be shorter than all roots.
 */

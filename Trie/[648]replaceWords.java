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
            TrieNode node = root;
            char[] charArr = word.toCharArray();
            for (int i = 0; i < charArr.length; i++) {
                char c = charArr[i];
                TrieNode child = node.children[c - 'a'];
                if (child == null || i == charArr.length - 1) {
                    sb.append(word + " ");
                    break;
                }
                if (child.word != null) {
                    sb.append(child.word + " ");
                    break;
                }
                node = child;
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}

/**
 * performance: 12 ms < 90%, 50 MB < 42%
 * notes: 1. take the Trie of roots not words in the sentence
 *        2. a word could be shorter than all roots.
 */

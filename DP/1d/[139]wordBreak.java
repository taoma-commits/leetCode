class Trie {
  class Node {
    Node[] children = new Node[26];
    boolean isWord = false; 
  }
  private Node root;
  public int depth;
  public Trie() {
    root = new Node();
  }
  public void insert(String word) {
    Node node = root;
    char[] arr = word.toCharArray();
    for (char c : arr) {
      if (node.children[c - 'a'] == null) {
        node.children[c - 'a'] = new Node();
      }
      node = node.children[c - 'a'];
    }
    node.isWord = true;
    depth = Math.max(arr.length, depth);
  }
  public boolean search(String word) {
    Node node = root;
    char[] arr = word.toCharArray();
    for (char c : arr) {
      if (node.children[c - 'a'] == null) {
        return false;
      }
      node = node.children[c - 'a'];
    }
    return node.isWord;
  }
}

class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    Trie trie = new Trie();
    for (String word : wordDict) {
      trie.insert(word);
    }
    int n = s.length();
    boolean[] dp = new boolean[n];
    for (int i = -1; i < n; i++) {
      if (i == -1 || dp[i]) {
        for (int j = i + 1; j < i + trie.depth + 1 && j < n; j++) {
          if (trie.search(s.substring(i + 1, j + 1))) {
            dp[j] = true;
            if (j == n - 1) return true;
          }
        }
      }      
    }
    return dp[n - 1];
  }
}

/**
 * performance: 2 ms < 97%
 * time complexity:
 * space complexity:
 * notes: key optimization j < i + trie.depth + 1
 */

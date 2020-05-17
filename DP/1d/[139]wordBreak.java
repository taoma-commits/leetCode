class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    int len = 0;
    for (String word : wordDict) {
      len = Math.max(word.length(), len);
    }
    int n = s.length();
    boolean[] dp = new boolean[n];
    for (int i = -1; i < n; i++) {
      if (i == -1 || dp[i]) {
        for (int j = i + 1; j < i + len + 1 && j < n; j++) {
          if (dp[j]) continue;
          if (wordDict.contains(s.substring(i + 1, j + 1))) {
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
 * time complexity: O(n^2). s = a...ab and wordDict = [a, aa, ..., a...a] is the worst case. 
 * For each i, it goes to check n - i places. 
 * space complexity: O(n)
 * notes: key optimization j < i + trie.depth + 1
 */


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
          if (dp[j]) continue;
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
 * performance: same 
 * time complexity: O(n^3). Search in trie is O(n) rather than O(1).
 * space complexity: O(n + m)
 * notes: another implementation involving Trie. 
 */

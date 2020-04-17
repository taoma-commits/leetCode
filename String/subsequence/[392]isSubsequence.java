class Solution {
  public boolean isSubsequence(String s, String t) {
    if (s.length() == 0) {
      return true;
    }
    int sIdx = 0;
    int tIdx = 0;
    while (tIdx < t.length()) {
      if (s.charAt(sIdx) == t.charAt(tIdx)) {
        sIdx++;
        if (sIdx == s.length()) {
          return true;
        }
      }
      tIdx++;
    }
    return false;
  }
}

/**
 * performance: 11 ms < 50%, 42 MB < 100%
 * time complexity: O(S + T) where S and T the length of s and t.
 * space complexity: O(1)
 */

// Follow-up: multiple input s.

class Solution {
  public boolean isSubsequence(String s, String t) {
    List<Integer>[] idx = new List[26];
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      if (idx[c - 'a'] == null) {
        idx[c - 'a'] = new ArrayList<Integer>();
      }
      idx[c - 'a'].add(i); // add indices in ascending order
    }

    int pre = 0;
    for (char c : s.toCharArray()) {
      if (idx[c - 'a'] == null) return false;
      int insertion_pt = Collections.binarySearch(idx[c - 'a'], pre);
      if (insertion_pt < 0) {
        insertion_pt = - insertion_pt - 1; // notes
      }
      if (insertion_pt == idx[c - 'a'].size()) return false;
      pre = idx[c - 'a'].get(insertion_pt) + 1;
    }
    return true;
  }
}

/**
 * performance: 28 ms < 15%, 62 MB < 7%
 * time complexity: preprocess O(T).
 * Each query O(S*log(?)), ? ~ T/26                 
 */

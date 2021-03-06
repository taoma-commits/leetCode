class Solution {
  int[] P = new int[26];
  Map<String, Integer> S = new HashMap<>();
  boolean res;
  public boolean wordPatternMatch(String p, String s) {
    backtrack(p, s, 0, 0);
    return res;
  }

  private void backtrack(String p, String s, int i, int j) {
    if (i == p.length()) {
      if (j == s.length()) res = true;
      return;
    }
    if (!res) {
      for (int k = j; k < s.length() - p.length() + i + 1; k++) {
        // System.out.println(p.charAt(i));
        // System.out.println(s.substring(j, k + 1));
        if (P[p.charAt(i) - 'a'] != S.getOrDefault(s.substring(j, k + 1), 0)) continue;
        if (P[p.charAt(i) - 'a'] == 0) {
          P[p.charAt(i) - 'a'] = i + 1;
          S.put(s.substring(j, k + 1), i + 1);
          backtrack(p, s, i + 1, k + 1);
          P[p.charAt(i) - 'a'] = 0;
          S.remove(s.substring(j, k + 1));
        } else {
          backtrack(p, s, i + 1, k + 1);
        }
      }
    }
  }
}

/**
 * performance: 2 ms < 100%, 40 MB < 100%
 * time complexity:??
 * space complexity: ??
 */

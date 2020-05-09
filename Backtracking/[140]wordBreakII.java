class Solution {
  String S;
  int n;
  Set<String> set;
  Map<Integer, List<String>> map = new HashMap<>();

  public List<String> wordBreak(String s, List<String> wordDict) {
    S = s;
    n = s.length();
    set = new HashSet<String>(wordDict);
    return backtrack(0);
  }

  private List<String> backtrack(int i) {
    List<String> res = new ArrayList<>();
    if (i == n) {
      res.add("");
      return res;
    }
    if (map.containsKey(i)) {
      return map.get(i);
    }
    for (int j = i + 1; j < n + 1; j++) {
      if (set.contains(S.substring(i, j))) {
        for (String str : backtrack(j)) {
          if (str.length() > 0) {
            str = " " + str;
          }
          res.add(S.substring(i, j) + str);
        }
      }
    }
    map.put(i, res);
    return res;
  }
}

/**
 * performance: 11 ms < 76%, 40 MB < 7%
 * time complexity: O(n^2) ??
 * space complexity: O(n^2) ??
 */

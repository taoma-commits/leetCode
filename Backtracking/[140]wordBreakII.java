class Solution {
  String S;
  int n;
  int len = 0;
  Set<String> set;
  Map<Integer, List<String>> map = new HashMap<>();

  public List<String> wordBreak(String s, List<String> wordDict) {
    S = s;
    n = s.length();
    set = new HashSet<String>(wordDict);
    for (String word : wordDict) {
      len = Math.max(len, word.length());
    }
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
    for (int j = i + 1; j < n + 1 && j < i + len + 1; j++) {
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
 * performance: 4 ms < 97%
 * time complexity: O(n^3), 1^2 + 2^2 + ... + n^2 ~ n^3.
 * space complexity: O(n^3) same as time complexity. 
 * notes: key optimization is the purning done by adding condition j < i + len + 1.
 */

class Solution {
  public List<String> wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    int len = 0;
    for (String word : wordDict) {
      len = Math.max(len, word.length());
    }
    ArrayList<String>[] dp = new ArrayList[n + 1];
    dp[0] = new ArrayList<String>();
    dp[0].add("");
    for (int i = 1; i < n + 1; i++) {
      ArrayList<String> list = new ArrayList<>();
      for (int j = 1; j < len + 1 && j < i + 1; j++) {
        if (dp[i - j].size() > 0 && wordDict.contains(s.substring(i - j, i))) {
          for (String str : dp[i - j]) {
            if (str.length() > 0) {
              str = str + " ";
            }
            list.add(str + s.substring(i - j, i));
          }
        }
      }
      dp[i] = list;
    }
    return dp[n];
  }
}

/**
 * performance: TLE
 * time complexity: O(n^3)
 * space complexity: O(n^3)
 * notes: why DP doesn't work? 
 */

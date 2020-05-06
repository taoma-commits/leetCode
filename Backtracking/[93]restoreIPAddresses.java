class Solution {
  List<String> res = new ArrayList<>(0);
  int n;
  public List<String> restoreIpAddresses(String s) {
    n = s.length();
    backtrack(s, 0, 4, new StringBuilder());
    return res;
  }

  private void backtrack(String s, int i, int count, StringBuilder sb) {
    if (n - i < count || n - i > count * 3) return;
    if (i == n && count == 0) {
      res.add(sb.toString());
      return;
    }
    int len = sb.length();
    for (int j = i + 1; j < i + 4 && j < n + 1; j++) {
      if (j - i == 2 && s.charAt(i) - '0' == 0) break;
      if (j - i == 3 && Integer.valueOf(s.substring(i, j)) > 255) break;
      sb.append(s.substring(i, j));
      if (count > 1) sb.append('.');
      backtrack(s, j, count - 1, sb);
      sb.setLength(len);
    }
  }
}

/**
 * performance: 1 ms < 100%, 38 MB < 7%
 * time complexity: O(1)!
 * space complexity: O(1)!
 */

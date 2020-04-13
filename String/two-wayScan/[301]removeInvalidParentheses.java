class Solution {
  public List<String> res = new ArrayList<>();

  public List<String> removeInvalidParentheses(String s) {
    remove(s, 0, 0, new char[]{'(', ')'});
    return res;
  }

  private void remove(String s, int scan_start, int remove_start, char[] par) {
    int count = 0;
    for (int i = scan_start; i < s.length(); i++) {
      if (s.charAt(i) == par[0]) {
        count--;
      }
      if (s.charAt(i) == par[1]) {
        count++;
      }
      if (count <= 0) {
        continue;
      }
      for (int j = remove_start; j <= i; j++) {
        if (s.charAt(j) == par[1] && (j == remove_start || s.charAt(j - 1) != par[1])) {
          remove(s.substring(0, j) + s.substring(j + 1), i, j, par);
        }
      }
      return;
    }
    String rev_s = new StringBuilder(s).reverse().toString();
    if (par[0] == '(') {
      remove(rev_s, 0, 0, new char[]{')', '('});
    } else {
      res.add(rev_s);
    }
  }
}

/**
 * performance: 2ms < 98%, 40 MB < 67%
 * time complexity: ?
 * space complexity: ?
 */

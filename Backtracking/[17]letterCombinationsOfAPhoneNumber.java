class Solution {
  List<String> res = new ArrayList<>();
  int n;
  public List<String> letterCombinations(String digits) {
    n = digits.length();
    backtrack(digits, 0, new StringBuilder());
    return res;
  }

  private void backtrack(String digits, int i, StringBuilder sb) {
    if (i == n) {
      if (n > 0) res.add(sb.toString());
      return;
    }
    int start;
    int len;
    int digit = digits.charAt(i) - '0';
    if (digit < 8) {
      start = (digit - 2) * 3;
    } else {
      start = (digit - 2) * 3 + 1;
    }
    if (digit == 7 || digit == 9) {
      len = 4;
    } else {
      len = 3;
    }
    for (int j = start; j < start + len; j++) {
      sb.append((char) (j + 'a'));
      backtrack(digits, i + 1, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}

/**
 * performance: 0 ms < 100%, 38 MB < 5%
 * time complexity: O((m + n)*4^n*3^m) where n is the number of 7's and 9's and m is the number of others in digits. 
 * space complexity: O(4^n*3*m)
 */

class Solution {
  public int numDecodings(String s) {
    int prev = 1;
    int current = 1;
    if (s.charAt(0) == '0') return 0;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == '0') {
        if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
          int temp = current;
          current = prev;
          prev = temp;
        } else {
          return 0;
        }
      } else if (s.charAt(i - 1) == '0' || (s.charAt(i - 1) - '0' > 2) || (s.charAt(i - 1) == '2' && s.charAt(i) - '0' > 6)) {
        prev = current;
      } else {
        current += prev;
        prev = current - prev;
      }
    }
    return current;
  }
}

/**
 * performance: 1 ms < 100%
 * time complexity: O(n)
 * space complexity: O(1)
 */

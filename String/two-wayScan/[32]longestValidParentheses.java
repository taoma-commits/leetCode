class Solution {
  public int longestValidParentheses(String s) {
    int n = s.length();
    int left = 0;
    int right = 0;
    int maxLen = 0;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '(') {
        left++;
      } else {
        right++;
      }
      if (left < right) {
        left = 0;
        right = 0;
      } else if (left == right) {
        maxLen = Math.max(left * 2, maxLen);
      }
    }
    left = 0;
    right = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (s.charAt(i) == '(') {
        left++;
      } else {
        right++;
      }
      if (right < left) {
        left = 0;
        right = 0;
      } else if (left == right) {
        maxLen = Math.max(left * 2, maxLen);
      }
    }
    return maxLen;
  }
}

/**
 * performance: 2 ms < 92%, 38 MB < 5%
 * notes: dp solution; stack solution
 * time complexity: O(n)
 * space complexity: O(1)
 */

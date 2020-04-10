class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int l1 = palindrome(s, i, i);
            int l2 = palindrome(s, i, i + 1);
            int max = Math.max(l1, l2);
            if (max > end - start + 1) {
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int palindrome(String s, int left, int right) {
        int i = left, j = right;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}

/**
 * performance: 32 ms < 75%. 38 MB < 24%
 * notes: central expansion + iteration
 * time complexity: O(n^2)
 * space complexity: O(1)
 */

 class Solution {
     public String longestPalindrome(String s) {
         if (s.length() == 0) return s;
         int n = s.length();
         int max = 0;
         int l = 0, r = 1;
         boolean[] dp = new boolean[n];
         for (int i = n - 1; i >= 0; i--) {
             for (int j = n - 1; j >= i; j--) {
                 dp[j] = (j - i < 2 || dp[j - 1]) && s.charAt(i) == s.charAt(j);
                 if (dp[j]) {
                     if (j - i > max) {
                         max = j - i;
                         l = i;
                         r = j + 1;
                     }
                 }
             }
         }
         return s.substring(l, r);
     }
 }

 /**
  * performance: 72 ms < 46%, 38 MB < 27%
  * notes: dp + memory optimization
  * time complexity: O(n^2)
  * space complexity: O(n)
  */

  class Solution {
      public String longestPalindrome(String s) {
          StringBuilder sb = new StringBuilder();
          sb.append("^#");
          for (char c : s.toCharArray()) {
              sb.append(c);
              sb.append('#');
          }
          sb.append('$');
          // trick: add '^' and '$' so
          // indices i + P[i] + 1 and i - P[i] - 1 always in bound.
          String t = sb.toString();

          int center = 1;
          int rb = 1;
          int[] P = new int[t.length()];
          P[0] = 0;

          for (int i = 1; i < t.length() - 1; i++) {
              int i_mirror = 2 * center - i;
              P[i] = Math.min(P[i_mirror], rb - i);
              // must be no larger than rb - i for i + P[i] + 1
              // to stay in bound.
              while (t.charAt(i + P[i] + 1) == t.charAt(i - P[i] - 1)) {
                  P[i]++;
              }
              if (i + P[i] > rb) {
                  center = i;
                  rb = i + P[i];
              }
          }

          int max = 0;
          int centerIdx = 0;
          for (int i = 0; i < t.length(); i++) {
              if (P[i] > max) {
                  max = P[i];
                  centerIdx = i;
              }
          }
          int l = (centerIdx - max) / 2;
          int r = l + max;
          return s.substring(l, r);
      }
  }
/**
 * performance: 7 ms < 95%, 39 MB < 14%;
 * notes: Manacher's algorithm
 */

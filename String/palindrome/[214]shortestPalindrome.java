class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int i = 0;
        for (int j = n - 1; j >= 0; j--) {
            if (arr[i] == arr[j]) {
                i++;
            }
        }
        if (i == n) {
            return s;
        } else {
            StringBuilder sb = new StringBuilder(s.substring(i));
            return sb.reverse().toString() + shortestPalindrome(s.substring(0, i)) + s.substring(i);
        }
    }
}

/**
 * performance: 8 ms < 77%, 38 MB < 6%
 * notes: 1. Claim. i == n implies s is a palindrome.
 *           Proof: the steps taken by left pointer is less than
 *                  or equal to the steps by right pointer. If
 *                  i == n then j == -1.
 * time complexity: the worst case is i == n - 1 and the subsquence
 *                  passed down to next call is s.substring(0, n - 1).
 *                  Each recursion costs at most 2 * n compares and
 *                  the recursion is at most depth n. O(n^2).
 * space complexity: O(n)
 */


 class Solution {
     public String shortestPalindrome(String s) {
         StringBuilder sb = new StringBuilder(s);
         String rev = sb.reverse().toString();
         String S = s + "#" + rev;
         int n = S.length();
         int[] T = new int[n];
         T[0] = 0;
         for (int i = 1; i < n; i++) {
             int t = T[i - 1];
             while (t > 0 && S.charAt(t) != S.charAt(i)) {
                 t = T[t - 1];
             }
             if (S.charAt(t) == S.charAt(i)) {
                 T[i] = t + 1;
             }
         }
         return rev.substring(0, s.length() - T[n - 1]) + s;
     }
 }

 /**
  * performance: 9 ms < 70%, 39.6 MB < 6%
  * notes: KMP algorithm
  * time complexity: O(n). t >= 0, t increases at most n times
  *                  so t decreases at most n times.
  */

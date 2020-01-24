/*
Runtime: 21 ms, faster than 51.58% of Java online submissions for Longest Palindromic Substring.
Memory Usage: 42 MB, less than 6.86% of Java online submissions for Longest Palindromic Substring.
Note: runtime unstable
*/

// dynamic programming? central expansion + iteration
// time complexity: O(n^2)
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

// Manacher's Algorithm ??

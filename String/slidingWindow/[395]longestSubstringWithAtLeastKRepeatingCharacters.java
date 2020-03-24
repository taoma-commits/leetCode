class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() == 0 || k > s.length()) {
            return 0;
        }
        if (k == 0) {
            return s.length();
        }
        int[] map = new int[26];
        char[] arr = s.toCharArray();
        for (char c : arr) {
            map[c - 'a']++;
        }
        boolean b = true;
        for (int i = 0; i < 26; i++) {
            if (map[i] < k && map[i] > 0) {
                b = false;
            }
        }
        if (b) {
            return arr.length;
        }

        int left = 0, right = 0;
        int maxLen = 0;
        while (right < arr.length) {
            if (map[arr[right] - 'a'] < k) {
                maxLen = Math.max(maxLen, longestSubstring(s.substring(left, right), k));
                left = ++right;
            } else {
                right++;
            }
        }
        maxLen = Math.max(maxLen, longestSubstring(s.substring(left, s.length()), k));
        return maxLen;
    }
}

/**
 * performance: 0 ms < 100%, 37.6 MB < 8%
 * notes: recursion and sliding window 
 */

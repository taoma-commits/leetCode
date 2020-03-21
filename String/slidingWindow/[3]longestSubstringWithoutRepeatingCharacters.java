class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int l = 0, r = 0, maxLen = 0;
        while (r < s.length()) {
            while (map[s.charAt(r)] > 0) {
                map[s.charAt(l++)]--;
            }
            map[s.charAt(r++)]++;
            if (maxLen < r - l) {
                maxLen = r - l;
            }
        }
        return maxLen;
    }
}

/**
 * performance: 3 ms < 97%, 39 MB < 13%
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int l = 0, r = 0, count = 0;
        int maxLen = 0;
        while (r < s.length()) {
            if (map[s.charAt(r)] > 0) {
                count = 1;
            }
            map[s.charAt(r)]++;
            r++;
            while (count > 0) {
                map[s.charAt(l)]--;
                if (map[s.charAt(l)] > 0) {
                    count = 0;
                }
                l++;
            }
            if (maxLen < r - l) {
                maxLen = r - l;
            }
        }
        return maxLen;
    }
}

/**
 * performance: 3 ms < 97%, 39 MB < 13%
 */

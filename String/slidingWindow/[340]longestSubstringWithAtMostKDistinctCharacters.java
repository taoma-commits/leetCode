class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0 || s.length() == 0) return 0;
        int maxLen = 0;
        int[] map = new int[128];
        int left = 0, right = 0;
        int count = 0;
        while (right < s.length()) {
            char c1 = s.charAt(right++);
            if (map[c1] == 0) {
                count++;
            }
            map[c1]++;
            while (count > k) {
                char c2 = s.charAt(left++);
                map[c2]--;
                if (map[c2] == 0) {
                    count--;
                }
            }
            if (right - left > maxLen) {
                maxLen = right - left;
            }
        }
        return maxLen;
    }
}

/**
 * performance: 2 ms < 100%, 38 MB < 16%.
 * time complexity: O(n).
 * space complexity: O(1).
 */

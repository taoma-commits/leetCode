class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int l = 0, r = 0, count = t.length();
        int minLen = Integer.MAX_VALUE, minIdx = 0;
        while (r < s.length()) {
            if (map[s.charAt(r)] > 0) {
                count--;
            }
            map[s.charAt(r)]--;
            r++;
            while (count == 0) {
                if (minLen > r - l) {
                    minLen = r - l;
                    minIdx = l;
                }
                map[s.charAt(l)]++;
                if (map[s.charAt(l)] > 0) {
                    count++;
                }
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minIdx, minIdx + minLen);
    }
}

/**
 * performance: 5 ms < 88%, 39.1 < 27%
 */

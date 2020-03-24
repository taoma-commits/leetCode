class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() == 0) return 0;
        char[] arr = s.toCharArray();
        int left = 0, right = 0;
        int count = 0;
        int maxLen = 0;
        int[] map = new int[128];
        while (right < arr.length) {
            char c1 = arr[right++];
            if (map[c1] == 0) {
                count++;
                if (count == 3) {
                    maxLen = Math.max(maxLen, right - left - 1);
                }
            }
            map[c1]++;
            while (count > 2) {
                char c2 = arr[left++];
                map[c2]--;
                if (map[c2] == 0) {
                    count--;
                }
            }
        }
        maxLen = Math.max(maxLen, right - left);
        return maxLen;
    }
}

/**
 * performance: 1 ms < 100%, 38 MB < 6%;
 */

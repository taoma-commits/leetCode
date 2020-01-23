/*
Runtime: 22 ms, faster than 20.52% of Java online submissions for Longest Substring Without Repeating Characters.
Memory Usage: 46.4 MB, less than 5.20% of Java online submissions for Longest Substring Without Repeating Characters.
*/

/*
* slicing window
* hash table
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        int max = 1, i = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int idx = 0; idx < s.length(); idx++) {
            if (map.getOrDefault(s.charAt(idx), -1) >= i) {
                max = Math.max(idx - i, max);
                i = map.get(s.charAt(idx)) + 1;
            }
            map.put(s.charAt(idx), idx);
        }
        max = Math.max(s.length() - i, max);
        return max;
    }
}

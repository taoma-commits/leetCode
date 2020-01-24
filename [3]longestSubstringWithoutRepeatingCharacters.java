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

/*
Runtime: 3 ms, faster than 92.00% of Java online submissions for Longest Substring Without Repeating Characters.
Memory Usage: 44 MB, less than 5.20% of Java online submissions for Longest Substring Without Repeating Characters.
*/

/*
* speed up by using int[] instead of hash map
* better code for sliding window
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[256];
        char[] str = s.toCharArray();
        int max = 0;
        for (int i = 0, p = 0; i < str.length; i++) {
            chars[str[i]]++;
            while (chars[str[i]] > 1) {
                chars[str[p]]--;
                p++;
            }
            max = Math.max(max, i - p + 1);
        }
        return max;
    }
}

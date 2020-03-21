class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        int[] p = new int[26];
        Map<String, Integer> s = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (p[pattern.charAt(i) - 'a'] != s.getOrDefault(arr[i], 0)) {
                return false;
            }
            p[pattern.charAt(i) - 'a'] = i + 1;
            s.put(arr[i], i + 1);
        }
        return true;
    }
}

/**
 * performance: 1 ms < 98%, 37.5 < 5%
 * notes: 1. map.getOrDefault(key, default) does NOT put(key, default)
          if key was not stored in hash map.
          2. difference between map.put(key, value) and map.replace(key, value)
 * time complexity:
 * space complexity:
 */

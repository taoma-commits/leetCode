class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < t.length(); j++) {
            if (hash[t.charAt(j) - 'a'] == 0) {
                return false;
            } else {
                hash[t.charAt(j) - 'a']--;
            }
        }
        return true;
    }
}

/**
* performance: 4 ms < 85%, 39 MB < 5%.
* time complexity: O(n). 
*/

class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++; // note
        }
        for (int j = 0; j < s.length(); j++) {
            if (hash[s.charAt(j) - 'a'] == 1) {
                return j;
            }
        }
        return -1;
    }
}

/**
* performance: 12ms < 78%, 45 MB < 5%.
* tag: hash
* notes: important trick: characters will automatically be
        casted to int when do arithmetic operations and
        indexing!!!
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] hash = new int[26];
            char[] arr = str.toCharArray();
            for (char c : arr) {
                hash[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#'); // note 1: to distinct #26 and #2#6
                sb.append(hash[i]);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}

/**
* performance: 21 ms < 27%, 45 MB < 7%
* notes: 1. "#" is necessary. 
        2.represent the equivalent class of anagrams by 26 ordered numbers.
*/

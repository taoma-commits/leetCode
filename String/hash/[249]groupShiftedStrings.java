class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < str.length(); i++) {
                sb.append('#');
                sb.append((str.charAt(i) - str.charAt(0) + 26) % 26); // note 1
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList()); // note 2
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values()); // note 3
    }
}

/**
* performance: 3 ms < 79%, 39 MB < 5%
* notes: 1. a % b remainder is negative if a < 0 and b > 0: use
            (a % b + b) % b instead to always get positive remainder.
        2. initialize ArrayList by new ArrayList()
        3. initialize ArrayList by new ArrayList(set)
* time complexity: O(n*k), n = strings.length, k = max(str.length)
* space complexity: O(n*k)
*/

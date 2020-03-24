class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) {
            return res;
        }
        final int l = words[0].length();
        final int L = l * words.length;
        if (s.length() < L) {
            return res;
        }

        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < l; i++) {
            Map<String, Integer> wordsSeen = new HashMap<>();
            int left = i, right = i;
            int count = 0;
            while (right + l <= s.length()) {
                String s1 = s.substring(right, right + l);
                right += l;
                if (!wordsMap.containsKey(s1)) {
                    left = right;
                    count = 0;
                    wordsSeen.clear();
                } else {
                    wordsSeen.put(s1, wordsSeen.getOrDefault(s1, 0) + 1);
                    count++;
                    while (wordsSeen.get(s1) > wordsMap.get(s1)) {
                        String s2 = s.substring(left, left + l);
                        wordsSeen.put(s2, wordsSeen.get(s2) - 1);
                        count--;
                        left += l;
                    }
                    if (count == words.length) {
                        res.add(left);
                    }
                }
            }
        }
        return res;
    }
}

/**
 * performance: 9 ms < 95%, 41 MB < 18%
 * time complexity: l = single word length, L = total length,
 *                  n = length of string s. O(l * n / l) = O(n).
 * space complexity: O(L + l * L)
 */

class WordDistance {
    private Map<String, List<Integer>> map = new HashMap<>();
    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++) {
            List<Integer> indices = map.getOrDefault(words[i], new ArrayList<>());
            indices.add(i);
            map.put(words[i], indices);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = this.map.get(word1);
        List<Integer> l2 = this.map.get(word2);
        int i1 = 0, i2 = 0, dist = Integer.MAX_VALUE;
        while (i1 < l1.size() && i2 < l2.size()) {
            int diff = l1.get(i1) - l2.get(i2);
            dist = Math.min(dist, Math.abs(diff));
            if (diff > 0) i2++;
            else i1++;
        }
        return dist;
    }
}

/*
* performance: 30 ms < 91%; 43 MB < 99%.
* time complexity: O(n), O(max(l1, l2))
* space complexity: O(n)
*/

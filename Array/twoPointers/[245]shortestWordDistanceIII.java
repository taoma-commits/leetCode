class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        long dist = Integer.MAX_VALUE, idx1 = dist, idx2 = - dist;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) idx1 = i;
            if (word2.equals(words[i])) {
                if (word1.equals(word2)) idx1 = idx2;
                idx2 = i;
            }
            dist = Math.min(dist, Math.abs(idx2 - idx1));
        }
        return (int) dist;
    }
}
/*
* performance: 3 ms < 47%, 37.8 mb < 15.71
* notes:
      1. let dist, idx1, and idx2 be long type can avoid overflow
      2. cast dist back to int type by (int) distance
* companies: LinkedIn 2, Microsoft 2, Adobe, Walmart lab, Google.
*/

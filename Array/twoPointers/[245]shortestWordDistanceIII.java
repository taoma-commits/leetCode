class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        long dist = Integer.MAX_VALUE, idx1 = dist, idx2 = - dist; //note 1
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) idx1 = i;
            if (word2.equals(words[i])) {
                if (word1.equals(word2)) idx1 = idx2; //note 3
                idx2 = i;
            }
            dist = Math.min(dist, Math.abs(idx2 - idx1));
        }
        return (int) dist;// note 2
    }
}
/*
* performance: 3 ms < 47%, 37.8 mb < 15.71
* notes:
      1. let dist, idx1, and idx2 be long type can avoid overflow
      2. cast dist back to int type by (int) distance
      3. special case when word1 == word2: do not want to update two pointers to
        the same index. Solution is to set pointer 1 to old pointer 2
        before update pointer 2.
* companies: LinkedIn 2, Microsoft 2, Adobe, Walmart lab, Google.
*/

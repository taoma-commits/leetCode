class Solution {
  public int shortestWordDistance(String[] words, String word1, String word2) {
    int min = Integer.MAX_VALUE;
    int i1 = -1;
    int i2 = -1;
    for (int i = 0; i < words.length; i++) {
      if (words[i].equals(word1)) {
        if (i1 <= i2 && i2 > -1) {
          min = Math.min(min, i - i2);
        }
        i1 = i;
      } 
      if (words[i].equals(word2)) {
        if (i2 < i1 && i > i1) {
          min = Math.min(min, i - i1);
        }
        i2 = i;
      }
    }
    return min;
  }
}

/**
 * performance: 2 ms < 81%
 * time complexity: O(n)
 * space complexity: O(1)
 */




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
* time complexity: O(n)  
* space complexity: O(1)
* notes: 1. long type avoids overflow
* 2. special case when word1 == word2: set pointer 1 to old pointer 2
* before update pointer 2.
*/

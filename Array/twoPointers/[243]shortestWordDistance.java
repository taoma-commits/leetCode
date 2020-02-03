class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int idx1 = -1, idx2 = -1, dist = words.length - 1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (idx1 < idx2) dist = Math.min(dist, i - idx2);
                idx1 = i;
            }
            if (words[i].equals(word2)) {
                if (idx2 < idx1) dist = Math.min(dist, i - idx1);
                idx2 = i;
            }
        }
        return dist;
    }
}

/*
* performance: 2ms < 98.12%; 36.1 MB < 91.70%.
* notes:
      1. compare strings: string1.equals(string2)
      2. two pointers
      3. idx1 and idx2 start at -1 instead of 0
      4. use hash table would be slower and use extra memory.
        Not worth it if only compute distance for one pair.
* companies: LinkedIn 8, Oracle 2
*/

class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int len = words.length;
        int dist = len, idx1 = - 2 * len, idx2 = - len;
        for (int i = 0; i < len; i++) {
            if (words[i].equals(word1)) idx1 = i;
            if (words[i].equals(word2)) idx2 = i;
            dist = Math.min(dist, Math.abs(idx1 - idx2));
        }
        return dist;
    }
}

/*
* A solution with less code
* notes:
      1. one has to carefully set the initial values of idx1 and idx2
      2. it does not do more compares than the first solution: Math.min replaces comparing idx1 and idx2
*/

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
* time complexity: O(n)
* space complexity: O(1)
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
* performance: 3 ms < 57%
*/

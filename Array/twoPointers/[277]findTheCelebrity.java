public class Solution extends Relation {
  public int findCelebrity(int n) {
    int i = 0;
    for (int j = 1; j < n; j++) {
      if (knows(i, j)) {
        i = j;
      }
    }
    for (int k = 0; k < i; k++) {
      if (knows(i, k) || !knows(k, i)) {
        return -1;
      }
    }
    for (int k = i + 1; k < n; k++) {
      if (!knows(k, i)) {
        return -1;
      }
    }
    return i;
  }
}

/**
 * performance: 23 ms < 67%, 39 MB < 100%
 * time complexity: O(n)
 * space complexity: O(1)
 */

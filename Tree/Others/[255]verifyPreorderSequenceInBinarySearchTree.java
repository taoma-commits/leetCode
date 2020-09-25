class Solution {
  public boolean verifyPreorder(int[] P) {
    int root = Integer.MIN_VALUE;
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < P.length; i++) {
      if (P[i] < root) {
        return false;
      }
      while (!stack.isEmpty() && stack.getLast() < P[i]) {
        root = stack.removeLast();
      }
      stack.addLast(P[i]);
    }
    return true;
  }
}

/**
 * performance: 11 ms < 80%
 * time complexity: O(n)
 * space complexity: O(h)
 * notes: monotonic stack
 */

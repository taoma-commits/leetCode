class Solution {
  public int maximalRectangle(char[][] matrix) {
    int m = matrix.length;
    if (m == 0) return 0;
    int n = matrix[0].length;
    if (n == 0) return 0;
    int[] H = new int[m + 2];
    H[0] = -1;
    H[m + 1] = -1;
    int max = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    for (int j = 0; j < n; j++) {
      for (int i = 0; i < m + 2; i++) {
        if (i > 0 && i < m + 1) {
          H[i] = matrix[i - 1][j] == '0' ? 0 : H[i] + 1;
        }
        while (i > 0 && H[i] < H[stack.peekLast()]) {
          max = Math.max(max, H[stack.pollLast()] * (i - stack.peekLast() - 1));
        }
        stack.addLast(i);
      }
    }
    return max;
  }
}

/**
 * performance: 14 ms < 44% 
 * time complexity: O(m * n)
 * space complexity: O(m)
 * notes: monotonic stack + sentinels 
 */

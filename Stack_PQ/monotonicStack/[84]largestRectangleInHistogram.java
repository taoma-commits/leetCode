 class Solution {
  public int largestRectangleArea(int[] heights) {
    int n = heights.length;
    int[] H = new int[n + 2];
    // add sentinels 
    H[0] = -1;
    H[n + 1] = -1;
    for (int i = 1; i < n + 1; i++) {
      H[i] = heights[i - 1];
    }
    int maxArea = 0;
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < n + 2; i++) {
      while (i > 0 && H[i] < H[stack.peekLast()]) {
        int j = stack.pollLast();
        // the widith is i - stack.peek() - 1
        maxArea = Math.max(maxArea, (i - stack.peekLast() - 1) * H[j]);  
      }
      stack.addLast(i);
    }
    return maxArea;
  }
}

/**
 * performance: 8 ms < 95%
 * time complexity: O(n)
 * space complexity: O(n)
 * notes: sentinels simplify code; width formula. 
 */

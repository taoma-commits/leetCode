class Solution {
  int maxLen = 0;
  int len = 0;
  int preVal;
  public int longestConsecutive(TreeNode root) {
    if (root != null) {
      preVal = root.val;
      backtrack(root);
    }
    return maxLen;
  }

  private void backtrack(TreeNode node) {
    int[] cache = new int[2];
    cache[0] = preVal;
    cache[1] = len;
    if (node.val != preVal + 1) len = 0;
    len++;
    maxLen = Math.max(len, maxLen);
    preVal = node.val;
    if (node.left != null) {
      backtrack(node.left);
    }
    if (node.right != null) {
      backtrack(node.right);
    }
    preVal = cache[0];
    len = cache[1];
  }
}

/**
 * performance: 1 ms < 100%
 * time complexity: O(n)
 * space complexity: O(depth)
 */

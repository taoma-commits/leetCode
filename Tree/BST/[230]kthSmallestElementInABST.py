class Solution:
  def kthSmallest(self, root: TreeNode, k: int) -> int:
    res = 0
    def helper(node):
        nonlocal k, res
        if node.left: helper(node.left)
        if k == 0: return
        k -= 1
        if k == 0:
            res = node.val
            return
        if node.right: helper(node.right)
    helper(root)
    return res

# performance: 48 ms < 99%
# time complexity: O(height + k)
# space complexity: O(height + k)

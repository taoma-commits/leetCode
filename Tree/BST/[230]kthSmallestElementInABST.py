class Solution:
  def kthSmallest(self, root: TreeNode, k: int) -> int:
    res = None
    count = k
    def dfs(node):
      nonlocal res
      nonlocal count
      if not node or res != None:
        return
      dfs(node.left)
      count -= 1
      if count == 0:
        res = node.val
        return
      dfs(node.right)
    dfs(root)
    return res

performance: 48 ms < 99%
time complexity: O(n)
space complexity: O()

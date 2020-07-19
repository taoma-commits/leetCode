class Solution:
  def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
    if not nums:
      return None
    mid = len(nums) // 2
    node = TreeNode(nums[mid])
    node.left = self.sortedArrayToBST(nums[: mid])
    node.right = self.sortedArrayToBST(nums[mid + 1 : ])
    return node

# performance: 48 ms < 98%
# time complexity: O(n)
# space complexity: O(log n); O(n) count output 

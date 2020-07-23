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

class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        count = 0
        def helper(lo, hi):
            nonlocal count
            if lo == hi: return None
            mid = (lo + hi) // 2
            left = helper(lo, mid)
            node = TreeNode(nums[count])
            node.left = left
            count += 1
            node.right = helper(mid + 1, hi)
            return node
        return helper(0, len(nums))

# performance: 52 ms < 95%
# time complexity: same
# space complexity: same
# notes: mimic [109] jn-order traversal simulation 

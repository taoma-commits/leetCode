class Solution:
  def firstBadVersion(self, n):
    """
    :type n: int
    :rtype: int
    """
    lo = 1
    hi = n
    while lo < hi:
      mid = (lo + hi) // 2
      if isBadVersion(mid):
        hi = mid
      else:
        lo = mid + 1
    return lo

# performance: 28 ms < 98%
# time complexity: O(log n)
# space complexity: O(1)

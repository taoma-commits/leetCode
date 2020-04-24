class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    int[] res = null;
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        res = new int[]{i, map.get(nums[i])};
        break;
      }
      map.put(target - nums[i], i);
    }
    return res;
  }
}

/**
 * performance: 2 ms < 100%, 40 MB < 5%
 * time complexity: O(n)
 * space complexity: O(n)
 * notes: note that both two-pass and one-pass algs
 * pass tests in which target is even and nums contains
 * two duplicates of target / 2.
 */

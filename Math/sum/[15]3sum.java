class Solution {
  List<List<Integer>> res = new ArrayList<>();
  public List<List<Integer>> threeSum(int[] nums) {
    int l = nums.length;
    if (l < 3) return res;
    Arrays.sort(nums);
    if (nums[0] > 0 || nums[l - 1] < 0) return res;
    for (int i = 2; i < nums.length; i++) {
      if (nums[i] < 0 || (i < l - 1 && nums[i] == nums[i + 1])) {
        continue;
      }
      twoSum(nums, i);
    }
    return res;
  }

  private void twoSum(int[] nums, int i) {
    int T = - nums[i];
    int l = 0, r = i - 1;
    while (l < r) {
      int L = nums[l], R = nums[r];
      if (L + R <= T) {
        while (++l < r && nums[l] == nums[l - 1]);
      }
      if (L + R >= T) {
        while (--r > l && nums[r] == nums[r + 1]);
      }
      if (L + R == T) {
        List<Integer> triple = new ArrayList<>();
        triple.add(L);
        triple.add(R);
        triple.add(- T);
        res.add(triple);
      }
    }
  }
}
/**
 * performance: 26 ms < 73%, 39 MB < 99%
 * time complexity: O(n^2)
 * space complexity: O(n)
 * notes: duplicates! 
 */

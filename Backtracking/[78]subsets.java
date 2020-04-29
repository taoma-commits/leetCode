class Solution {
  List<List<Integer>> res = new ArrayList<>();

  private void backtrack(int i, int[] nums, ArrayList<Integer> temp) {
    if (i == nums.length) {
      res.add(new ArrayList(temp));
      return;
    }
    backtrack(i + 1, nums, temp);
    temp.add(nums[i]);
    backtrack(i + 1, nums, temp);
    temp.remove(temp.size() - 1);
  }

  public List<List<Integer>> subsets(int[] nums) {
    backtrack(0, nums, new ArrayList());
    return res;
  }
}

/**
 * performance: 1 ms < 100%, 40 MB
 * time complexity: O(n * 2^n), copy a subset into res costs O(n) in the worst scenario.
 * space complexity: O(n * 2^n)
 */
 
class Solution {
  List<List<Integer>> res = new ArrayList<>();

  private void backtrack(int i, int[] nums, ArrayList<Integer> temp) {
    res.add(new ArrayList(temp));
    for (int j = i; j < nums.length; j++) {
      temp.add(nums[j]);
      backtrack(j + 1, nums, temp);
      temp.remove(temp.size() - 1);
    }
  }

  public List<List<Integer>> subsets(int[] nums) {
    backtrack(0, nums, new ArrayList());
    return res;
  }
}

/**
 * A different backtracking. Same performance and computational complexity.
 */

class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    int n = nums.length;
    for (int i = 0; i < Math.pow(2, n); i++) {
      List<Integer> temp = new ArrayList<>();
      int j = i;
      for (int num : nums) {
        if ((j & 1) > 0) {
          temp.add(num);
        }
        j = j >> 1;
      }
      res.add(temp);
    }
    return res;
  }
}

/**
 * Same performance and complexity. Bitmask.
 */


 

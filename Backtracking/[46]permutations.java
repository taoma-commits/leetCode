class Solution {
  List<List<Integer>> res = new ArrayList<>();
  public List<List<Integer>> permute(int[] nums) {
    boolean[] seen = new boolean[nums.length];
    backtrack(nums, seen, new ArrayList());
    return res;
  }
  private void backtrack(int[] nums, boolean[] seen, ArrayList<Integer> temp) {
    if (temp.size() == nums.length) {
      res.add(new ArrayList(temp));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (seen[i]) continue;
      temp.add(nums[i]);
      seen[i] = true;
      backtrack(nums, seen, temp);
      seen[i] = false;
      temp.remove(temp.size() - 1);
    }
  }
}

/**
 * performance: 2 ms < 80%, 40 MB < 7%
 * time complexity: O(n * n!)
 * space complexity: O(n * n!)
 * notes: use an array 'seen' to mark visited nums.
 * The use of extra space keeps the outcome in lexicographical order
 * if the given array nums is sorted!
 */


 class Solution {
  int n;
  List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> permute(int[] nums) {
    n = nums.length;
    List<Integer> list = new ArrayList<>();
    for (int num : nums) list.add(num);
    backtrack(list, 0);
    return res;
  }

  private void backtrack(List<Integer> list, int i) {
    if (i == n) {
      res.add(new ArrayList(list));
    }
    for (int j = i; j < n; j++) {
      Collections.swap(list, i, j);
      backtrack(list, i + 1);
      Collections.swap(list, i, j);
    }
  }
}

/**
 * performance: 1 ms < 100%, 40 MB < 7%
 * time complexity: O(n * n!)
 * space complexity: O(n * n!)
 */

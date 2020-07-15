class Solution {
  int n;
  int mid;
  public void wiggleSort(int[] nums) {
    n = nums.length;
    if (n < 2) return;
    mid = ((n + 1) >> 1);
    partition(nums, 0, n - 1, mid);
  }

  private int map(int i) {
    if (i < mid) {
      return (mid - i - 1) * 2;
    } else {
      return (n - i - 1) * 2 + 1;
    }
  }

  private void partition(int[] nums, int lo, int hi, int k) {
    int i = lo;
    int lt = lo;
    int gt = hi;
    int V = nums[map(lo)];
    while (i <= gt) {
      if (nums[map(i)] > V) {
        swap(nums, map(i), map(gt--));
      } else if (nums[map(i)] < V) {
        swap(nums, map(i++), map(lt++));
      } else {
        i++;
      }
    }
    if (k < lt) {
      partition(nums, lo, lt - 1, k);
    } else if (k >= i) {
      partition(nums, i, hi, k);
    } else {
      return;
    }
  }

  private void swap(int[] nums, int i, int j) {
    int cache = nums[i];
    nums[i] = nums[j];
    nums[j] = cache;
  }
}

/**
 * performance: 32 ms < 24%
 * time complexity: O(n) in average
 * space complexity: O(1)
 * notes: 1. rotate and shuffle; 2. use mapping to avoid save copy of arrays.
 */

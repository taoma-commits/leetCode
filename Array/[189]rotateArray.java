class Solution {
    private void reverse(int[] nums, int front, int end) {
        int temp = 0;
        while (front < end) {
            temp = nums[front];
            nums[front++] = nums[end];
            nums[end--] = temp;
        }
    }
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len; // avoid k - 1 out of bounds as index
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }
}

/**
 * performance: 1 ms < 49%, 46 MB < 6%
 * time complexity: O(n)
 * space complexity: O(1)
 * notes: trick triple reverse
 */



class Solution {
  private int gcd(int n, int k) {
    int remainder = n;
    int divisor = k;
    int cache;
    while (divisor != 0) {
      cache = divisor;
      divisor = remainder % divisor;
      remainder = cache;
    }
    return remainder;
  }

  public void rotate(int[] nums, int k) {
    int n = nums.length;
    k = k % n;
    int numOrbits = gcd(n, k);
    int cache;
    for (int i = 0; i < numOrbits; i++) {
      int img = (i + k) % n;
      cache = nums[i];
      while (img != i) {
        int temp = nums[img];
        nums[img] = cache;
        cache = temp;
        img = (img + k) % n;
      }
      nums[i] = cache;
    }
  }
}

/**
 * performance: 0 ms < 100%, 40 MB < 7%
 * time complexity: O(n) + time complexity of Euclidean algorithm
 * space complexity: O(1)
 * notes: finite group isomorphism orbits
 */

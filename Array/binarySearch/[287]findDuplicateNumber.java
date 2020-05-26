class Solution {
  public int findDuplicate(int[] nums) {
    int n = nums.length;
    int l = 1;
    int r = n;
    while (l < r) {
      int mid = (l + r) >> 1; 
      int count = 0;
      for (int i = 0; i < n; i++) {
        if (nums[i] <= mid) {
          count++;
        }
      }
      if (count <= mid) {
        l = mid + 1;
      } else {
        r = mid;
      }
    }
    return r;
  }
}

/**
 * performance: 3 ms < 60%
 * time complexity = O(n * log(n))
 * space complexity = O(1)
 * notes: binary search in numbers 1 to n
 */

class Solution {
  public int findDuplicate(int[] nums) {
    int fast = 0;
    int slow = 0;
    while (true) {
      fast = nums[nums[fast]];
      slow = nums[slow];
      if (fast == slow) break; 
    }
    slow = 0;
    while (fast != slow) {
      fast = nums[fast];
      slow = nums[slow];
    }
    return slow;
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n) because the 1st meet of two pointers will happen before slow pointer have visited all numbers in the cycle. 
 * space complexity: O(1)
 * notes: Floyd's slow and fast pointers; 
 */


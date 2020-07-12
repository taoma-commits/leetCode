class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int ptr0 = m + n - 1;
    int ptr1 = m - 1;
    int ptr2 = n - 1;
    while (ptr1 > -1 && ptr2 > -1) {
      if (nums1[ptr1] < nums2[ptr2]) {
        nums1[ptr0--] = nums2[ptr2--];
      } else {
        nums1[ptr0--] = nums1[ptr1--];
      }
    }
    while (ptr2 > -1) {
      nums1[ptr0--] = nums2[ptr2--];
    }
  }
}




/**
 * performance: 0 ms < 100%
 * time complexity: O(m + n)
 * space complexity: O(m + n)
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i, j, k;
        i = m + n - 1;
        j = m - 1;
        k = n - 1;
        while (k >= 0) {
            if (j < 0) nums1[i--] = nums2[k--];
            else nums1[i--] = (nums1[j] > nums2[k])? nums1[j--] : nums2[k--];
        }
    }
}

/**
 * same
 */

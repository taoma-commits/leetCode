/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Merge Sorted Array.
@dataStructure: array
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

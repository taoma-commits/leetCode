class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int lm = (l1 + l2 + 1) / 2;
        int rm = (l1 + l2 + 2) / 2;
        return (findKth(nums1, nums2, 0, 0, lm) + findKth(nums1, nums2, 0, 0, rm)) * 0.5;
    }


    private int findKth(int[] nums1, int[] nums2, int s1, int s2, int k) {
        int len1 = nums1.length - s1;
        int len2 = nums2.length - s2;

        if (len1 > len2) {
            return findKth(nums2, nums1, s2, s1, k);
        }
        if (len1 == 0) {
            return nums2[s2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[s1], nums2[s2]);
        }

        int i1 = s1 + Math.min(len1, k / 2) - 1;
        int i2 = s2 + Math.min(len2, k / 2) - 1;

        if (nums1[i1] >= nums2[i2]) {
            return findKth(nums1, nums2, s1, i2 + 1, k - (i2 - s2 + 1));
        } else {
            return findKth(nums1, nums2, i1 + 1, s2, k - (i1- s1 + 1));
        }
    }
}

/**
* performance: 3ms < 98%, 51 MB < 5%.
* tag: binary search
* notes: 1. find the kth element of two sorted array
        2. time complexity O(log(m + n))
*/

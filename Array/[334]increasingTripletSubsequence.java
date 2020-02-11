class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int mid = min;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > mid) {
                return true;
            } else if (nums[i] > min) {
                mid = Math.min(nums[i], mid);
            } else {
                min = nums[i];
            }
        }
        return false;
    }
}

/**
* performance: 1 ms < 99%, 46.1 MB < 5%.
* tag: dp??
* companies: Facebook, Amazon.
*/

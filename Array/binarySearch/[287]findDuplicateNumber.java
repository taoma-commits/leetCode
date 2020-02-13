class Solution {
    public int findDuplicate(int[] nums) {
        int lo = 1;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}

/**
* performance: 5 ms < 33%, 48 MB < 5%.
* notes: time complexity = O(nlogn), space complexity = O(1)
* companies: Amazon, Microsoft, Google.
*/

// best solution: find the cycle, then find cycle entrance. 

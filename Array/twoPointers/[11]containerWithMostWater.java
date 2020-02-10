class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int area = 0;
        while (l < r) {
            area = Math.max(area, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            }
            else {
                r--;
            }
        }
        return area;
    }
}

/**
* performance: 1 ms < 100%, 41.1 MB < 13%.
* tag: two pointers
* companies: Amazon, Facebook, Google, Goldman-Sachs.
*/

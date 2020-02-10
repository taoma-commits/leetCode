/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Container With Most Water.
Memory Usage: 41.1 MB, less than 13.46% of Java online submissions for Container With Most Water.
*/

//tag: array, two pointers.

class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, max = 0;
        while (i < j) {
            if (height[i] <= height[j]) {
                max = Math.max(max, height[i] * (j - i));
                int k = 1;
                while (height[i + k] <= height[i] && k < j - i) k++;
                i += k;
            }
            else {
                max = Math.max(max, height[j] * (j - i));
                int k = 1;
                while (height[j - k] <= height[j] && k < j - i) k++;
                j -= k;
            }
        }
        return max;
    }
}

/*
same performance, better written code.
*/

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

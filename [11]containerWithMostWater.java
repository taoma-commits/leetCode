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

public class Solution {
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}

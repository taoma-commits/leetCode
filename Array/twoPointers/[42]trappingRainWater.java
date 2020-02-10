class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int water = 0;
        int l = 0;
        int r = height.length - 1;
        int lh = 0; // note 1
        int rh = 0; // note 1

        while (l <= r) { // caution!
            if (lh <= rh) {
                if (height[l] < lh) {
                    water += lh - height[l];
                } else {
                    lh = height[l];
                }
                l++;
            } else {
                if (height[r] < rh) {
                    water += rh - height[r];
                } else {
                    rh = height[r];
                }
                r--;
            }
        }
        return water;
    }
}

/*
* performance: 1 ms < 100%, 43.6 MB < 5%.
* tag: two pointers
* notes: 1. left (right) pointer must stop when current height is equal to lh (rh)!
         2. could not figure this out in hours: assign extra lh and rh is NATRUAL!
         3. time complexity = O(n); space complexity = O(1).
* companies: Amazon(53), Goldman-Sachs, Microsoft, Facebook.
*/

class Solution {
    public int trap(int[] height) {
        int water = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[i] > height[stack.peek()]) {
                int b = stack.pop();
                if (stack.empty()) {
                    break;
                }
                int l = stack.peek();
                water += (Math.min(height[l], height[i]) - height[b]) * (i - l - 1);
            }
            stack.push(i);
        }
        return water;
    }
}

/**
* performance: 4 ms < 34%, 46.3 < 5%.
* notes:
        1. the idea is to compute each horizontal water strip not vertical ones.
        2. implement by stack
*/

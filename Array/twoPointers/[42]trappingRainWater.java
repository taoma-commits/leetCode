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
* time complexity: O(n)
* space complexity: O(1)
* notes: pay attention to < and <= to avoid out of bound error.
*/

class Solution {
  public int trap(int[] height) {
    int n = height.length;
    int lh = 0;
    int rh = 0;
    int volumn = 0;
    int l = 0;
    int r = n - 1;
    while (l <= r) {
      if (lh < rh) {
        while (height[l] <= lh) {
          volumn += lh - height[l++];
        }
        lh = height[l++];
      } else {
        while (height[r] < rh) {
          volumn += rh - height[r--];
        }
        rh = height[r--];
      }
    }
    return volumn;
  }
}

/**
 * performance: 1 ms < 100%, 39 MB < 13%
 * time complexity: same
 * space complexity: same
 */

class Solution {
  public int trap(int[] height) {
    int water = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < height.length; i++) {
      while (!stack.isEmpty() && height[i] > height[stack.peekLast()]) {
        int j = stack.pollLast();
        if (stack.isEmpty()) {
          break;
        }
        int k = stack.peekLast();
        water += (Math.min(height[k], height[i]) - height[j]) * (i - k - 1);
      }
      stack.addLast(i);
    }
    return water;
  }
}

/**
* performance: 2 ms < 46%
* time complexity: O(n), each bar is pushed and poped once.
* space complexity: O(n)
* notes: 1. compute each horizontal water strip instead of vertical ones. 
* 2. monotonic stack
*/

class Solution {
  public int trap(int[] height) {
    int n = height.length;
    int[] left = new int[n];
    int[] right = new int[n];
    int max_left = 0;
    int max_right = 0; 
    for (int i = 0; i < n; i++) {
      max_left = Math.max(max_left, height[i]);
      max_right = Math.max(max_right, height[n - i - 1]);
      left[i] = max_left;
      right[n - i - 1] = max_right;
    }
    int volumn = 0;
    for (int i = 0; i < n; i++) {
      volumn += Math.min(left[i], right[i]) - height[i];
    }
    return volumn;
  }
}

/**
 * performance: 1 ms < 100%
 * time complexity: O(n)
 * space complexity: O(n)
 * notes: left and right DP. 
 */

class Solution {
  public boolean isHappy(int n) {
    int slow = n;
    int fast = getNext(n);
    while (fast != 1 && fast != slow) {
      slow = getNext(slow);
      fast = getNext(getNext(fast));
    }
    return fast == 1;
  }

  private int getNext(int n) {
    int x = n;
    int res = 0;
    while (x > 0) {
      res += (x % 10) * (x % 10);
      x = x / 10;
    }
    return res;
  }
}

/**
 * performance: 1 ms < 100%
 * time complexity: O(log(n)) not obvious.
 * space complexity: O(1)
 * notes: Floyd's algorithm; fast and slow pointers detect cycle.
 */

class Solution {
  public boolean verifyPreorder(int[] P) {
    int root = Integer.MIN_VALUE;
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < P.length; i++) {
      if (P[i] < root) {
        return false;
      }
      while (!stack.isEmpty() && stack.getLast() < P[i]) {
        root = stack.removeLast();
      }
      stack.addLast(P[i]);
    }
    return true;
  }
}

/**
 * performance: 11 ms < 80%
 * time complexity: O(n)
 * space complexity: O(h)
 * notes: monotonic stack
 */

 class Solution {
   public boolean verifyPreorder(int[] P) {
     int lo = Integer.MIN_VALUE;
     int i = -1;
     for (int p : P) {
       if (p < lo) {
         return false;
       }
       while (i > -1 && p > P[i]) {
         lo = P[i--];
       }
       P[++i] = p;
     }
     return true;
   }
 }

 /**
  * performance: 2 ms < 100%
  * time complexity: O(n)
  * space complexity: O(1)
  * notes: To achieve constanct space complexity, replace stack with array.
  */

  class Solution {
   public boolean verifyPreorder(int[] P) {
     return helper(P, 0, P.length, Integer.MIN_VALUE, Integer.MAX_VALUE);
   }

   private boolean helper(int[] P, int L, int R, int lo, int hi) {
     if (L > R - 1) return true;
     if (P[L] < lo || P[L] > hi) {
       return false;
     }
     int i = L + 1;
     while (i < P.length && P[L] > P[i]) {
       i++;
     }
     return helper(P, L + 1, i, lo, P[L]) && helper(P, i, R, P[L], hi);
   }
 }

 /**
  * performance: 202 ms < 35%
  * time complexity: O(n)
  * space complexity: O(h)
  * notes: divide and conquer 
  */

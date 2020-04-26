class Solution {
  public int countDigitOne(int n) {
    Deque<Integer> stack = new ArrayDeque<>();
    long res = 0;
    long P = 0;
    int countOne = 0;
    int count = 0;
    while (n > 0) {
      int digit = n % 10;
      if (digit == 1) {
        res += P;
        countOne++;
      }
      stack.push(digit);
      P += digit * Math.pow(10, count);
      n = n / 10;
      count++;
    }
    // System.out.println(res + countOne);
    long R = 0;
    while (!stack.isEmpty()) {
      int curDigit = stack.pop();
      int size = stack.size();
      res += Math.pow(10, size) * R;
      // System.out.println("update1: " + res);
      if (curDigit > 1) res += Math.pow(10, size);
      // System.out.println("update2: " + res);
      R = R * 10 + curDigit; 
    }
    return (int) res + countOne;
  }
}

/**
 * performance: 0 ms < 100%, 36.6 MB < 33%
 * time complexity: O(n)
 * space complexity: O(n)
 */

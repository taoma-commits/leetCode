class Solution {
  public int myAtoi(String str) {
    int[][] table = new int[][]{
      { 0, 1, 2, 3,-1},
      {-1,-1,-1, 3,-1},
      {-1,-1,-1, 3,-1},
      {-1,-1,-1, 3,-1}
    };
    int state = 0, i = 0, sign = 1;
    int res = 0;
    while (i < str.length()) {
      state = table[state][getID(str.charAt(i))];
      if (state == -1) return sign * res;
      if (state == 2) {
        sign = -1;
      }
      if (state == 3) {
        if (sign > 0 && (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' >= 7))) {
          return Integer.MAX_VALUE;
        }
        if (sign < 0 && (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' >= 8))) {
          return Integer.MIN_VALUE;
        }
        res = res * 10 + (str.charAt(i) - '0');
      }
      i++;
    }
    return sign * res;
  }

  private int getID(char c) {
    switch (c) {
      case ' ' : return 0;
      case '+' : return 1;
      case '-' : return 2;
      default : if (c - '0' >= 0 && c - '0' < 10) {
        return 3;
      }
    }
    return 4;
  }
}

/**
 * performance: 2 ms < 98%, 39 MB < 6%
 * time complexity: O(n)
 * space complexity: O(1)
 */

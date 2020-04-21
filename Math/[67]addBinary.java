class Solution {
  public String addBinary(String a, String b) {
    int m = a.length();
    int n = b.length();
    if (m < n) {
      return addBinary(b, a);
    }
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    int i = m - 1;
    int j = n - 1;
    int sum = 0;
    while (i >= 0 || carry > 0) {
      sum = carry;
      if (i >= 0) {
        sum += a.charAt(i--) - '0';
      }
      if (j >= 0) {
        sum += b.charAt(j--) - '0';
      }
      carry = sum < 2 ? 0 : 1;
      sb.append((char) sum % 2);
    }
    return sb.reverse().toString();
  }
}

/**
 * performance: 2 ms < 98%, 38 MB < 7%
 * time complexity: O(max(M, N))
 * space complexity: O(max(M, N)) for StringBuilder
 * notes: two pointers to avoid reverse a and b - 1 ms;
 * sb.append then reverse faster than sb.insert(0, char) - 1 ms.
 */

 /**
  * Alternate solution: XOR 
  */

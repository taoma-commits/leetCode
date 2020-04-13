class Solution {
  public List<Integer> diffWaysToCompute(String input) {
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (c == '*' || c == '+' || c == '-') {
        List<Integer> before = diffWaysToCompute(input.substring(0, i));
        List<Integer> after = diffWaysToCompute(input.substring(i + 1));
        for (int j : before) {
          for (int k : after) {
            if (c == '*') {
              res.add(j * k);
            }
            if (c == '+') {
              res.add(j + k);
            }
            if (c == '-') {
              res.add(j - k);
            }
          }
        }
      }
    }
    if (res.isEmpty()) {
      res.add(Integer.valueOf(input));
    }
    return res;
  }
}

/**
 * performance: 2 ms < 89%, 40 MB < 14%
 * time complexity:
 * space complexity: 
 */

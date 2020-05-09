class Solution {
  String S;
  int n;
  int T;
  List<String> res = new ArrayList<>();
  public List<String> addOperators(String num, int target) {
    S = num;
    n = S.length();
    if (n == 0) return res;
    T = target;
    backtrack(0, new StringBuilder(), 0, 0, 0);
    return res;
  }

  private void backtrack(int i, StringBuilder sb, long value, long preOperand, long currentOperand) {
    if (i == n) {
      if (value == T && currentOperand == 0) {
        res.add(sb.substring(1, sb.length()).toString());
      }
      return;
    }
    int len = sb.length();
    currentOperand = currentOperand * 10 + (S.charAt(i) - '0');
    if (currentOperand != 0) {
      backtrack(i + 1, sb, value, preOperand, currentOperand);
    }

    sb.append('+');
    sb.append(currentOperand);
    backtrack(i + 1, sb, value + currentOperand, currentOperand, 0);
    sb.setLength(len);

    if (sb.length() > 0) {
      sb.append('-');
      sb.append(currentOperand);
      backtrack(i + 1, sb, value - currentOperand, - currentOperand, 0);
      sb.setLength(len);
      sb.append('*');
      sb.append(currentOperand);
      backtrack(i + 1, sb, value - preOperand + preOperand * currentOperand, preOperand * currentOperand, 0);
      sb.setLength(len);
    }
  }
}

/**
 * performance: 42 ms < 80%, 40 MB < 100%
 * time complexity: O(n*4^n) or O(4^n) not counting output.
 * space complexity: O(n*4^n) or O(n) not counting output.
 * notes: 
 * 0. Think with operands rather than digits. 
 * 1. Extra care should be taken regarding multiplications.
 * 2. avoid zero in the most significant digit.
 */
 
 class Solution {
  String S;
  int n;
  int T;
  List<String> res = new ArrayList<>();
  public List<String> addOperators(String num, int target) {
    S = num;
    n = S.length();
    if (n == 0) return res;
    T = target;
    backtrack(0, "", 0, 0, 0);
    return res;
  }

  private void backtrack(int i, String temp, long value, long preOperand, long currentOperand) {
    if (i == n) {
      if (value == T && currentOperand == 0) res.add(temp.substring(1, temp.length()));
      return;
    }
    currentOperand = currentOperand * 10 + (S.charAt(i) - '0');
    if (currentOperand != 0) {
      backtrack(i + 1, temp, value, preOperand, currentOperand);
    }
    backtrack(i + 1, temp + "+" + Long.toString(currentOperand), value + currentOperand, currentOperand, 0);
    if (temp.length() > 0) {
      backtrack(i + 1, temp + "-" + Long.toString(currentOperand), value - currentOperand, - currentOperand, 0);
      backtrack(i + 1, temp + "*" + Long.toString(currentOperand), value - preOperand + preOperand * currentOperand, preOperand * currentOperand, 0);
    }
  }
}

/**
 * performance: 120 ms < 53%
 * time complexity: same
 * space complexity: same
 * notes: concise code worse performance.
 */
 
 

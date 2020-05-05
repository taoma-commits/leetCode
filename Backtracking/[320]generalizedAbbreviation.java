class Solution {
  List<String> res = new ArrayList<>();
  int n;
  public List<String> generateAbbreviations(String word) {
    n = word.length();
    backtrack(word, 0, "", false);
    return res;
  }

  private void backtrack(String word, int i, String temp, boolean prev_num) {
    if (i == n) {
      res.add(temp);
      return;
    }
    backtrack(word, i + 1, temp + word.substring(i, i + 1), false);
    if (!prev_num) {
      for (int j = i; j < n; j++) {
        backtrack(word, j + 1, temp + String.valueOf(j - i + 1), true);
      }
    }
  }
}

/**
 * performance: 12 ms < 71%, 45 MB < 100%
 * time complexity: O(n*2^n)
 * space complexity: O(n*2^n)
 * notes: this code is a all-in-one code for all backtracking problem. 
 * It does not modify temp in-place but create a new copy of temp and
 * pass it on after modification. It provides a simpler code that works
 * for broader set of backtracking problems at the cost of extra memory
 * usage.
 */
 

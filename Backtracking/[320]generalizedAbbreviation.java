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

class Solution {
  List<String> res = new ArrayList<>();
  int n;
  public List<String> generateAbbreviations(String word) {
    n = word.length();
    backtrack(word, 0, 0, new StringBuilder());
    return res;
  }

  private void backtrack(String word, int i, int k, StringBuilder temp) {
    int len = temp.length(); // keep track of length (could add multiple digits at once)  
    if (i == n) {
      if (k > 0) temp.append(k);
      res.add(temp.toString());
    } else {
      backtrack(word, i + 1, k + 1, temp);
      if (k > 0) {
        temp.append(k);
      }
      temp.append(word.charAt(i));
      backtrack(word, i + 1, 0, temp);
    }
    temp.setLength(len); // setLength() saves 1ms running time 
  }
}

/**
 * performance: 6 ms < 98%, 45 MB < 100%
 * time complexity: same
 * space complexity: same 
 * notes: keep track of length of StringBuilder rather than delete the last added character.
 * The latter one does not work because the numbers added could have multiple digits. 
 */

class Solution {
  public List<String> generateAbbreviations(String word) {
    List<String> res = new ArrayList<>();
    int n = word.length();
    for (int i = 0; i < (1 << n); i++) {
      res.add(abbreviate(word, i));
    }
    return res;
  }

  private String abbreviate(String word, int i) {
    int k = 0, n = word.length();
    StringBuilder sb = new StringBuilder();
    for (int j = 0; j < n + 1; j++, i >>= 1) {
      if (j == n || (i & 1) == 0) {
        if (k > 0) sb.append(k);
        if (j < n) {
          sb.append(word.charAt(j));
          k = 0;
        }
      } else {
        k++;
      }
    }
    return sb.toString();
  }
}

/**
 * performance: 21 ms < 54%, 45 MB < 100%
 * time complexity: same 
 * space complexity: same
 * notes: (Knuth) bit manipulation
 */
 

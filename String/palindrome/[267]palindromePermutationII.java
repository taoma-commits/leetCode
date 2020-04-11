class Solution {
    Set<String> set = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    int center = -1;
    int[] map = new int[128];

    public List<String> generatePalindromes(String s) {
      if (!prescreen(s)) {
        return new ArrayList<>();
      }
      int k = 0;
      char[] chars = new char[s.length() / 2];
      for (int i = 0; i < 128; i++) {
        for (int j = 0; j < map[i] / 2; j++) {
          chars[k++] = (char) i;
        }
      }
      backtrack(chars, 0, center);
      return new ArrayList<String>(set);
    }

    private void swap(char[] chars, int i, int j) {
      char temp = chars[i];
      chars[i] = chars[j];
      chars[j] = temp;
    }

    private void backtrack(char[] chars, int start, int center) {
      if (start == chars.length) {
        String str = new String(chars);
        String rev = new StringBuilder(str).reverse().toString();
        set.add(str + (center == -1 ? "" : (char)center) + rev);
      }
      // use set to avoid duplicates
      for (int i = start; i < chars.length; i++) {
        if (start == i || chars[start] != chars[i]) {
          swap(chars, start, i);
          backtrack(chars, start + 1, center);
          swap(chars, start, i);
        }
      }
    }

    private boolean prescreen(String s) {
      for (char c : s.toCharArray()) {
        map[c]++;
      }
      int parity = 0;
      for (int i = 0; i < 128; i++) {
        if (map[i] % 2 == 1) {
          parity += 1;
          if (parity > 1) {
            return false;
          }
          center = i;
          map[i]--;
        }
      }
      return true;
    }
}

/**
 * performance: 8 ms < 56%, 40 MB < 100%
 * notes: 1. backtrack
 */

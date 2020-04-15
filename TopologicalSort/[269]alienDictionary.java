class Solution {
  Map<Character, List<Character>> map = new HashMap<>();
  boolean[] marked = new boolean[26];
  boolean[] onPath = new boolean[26];
  Deque<Character> stack = new ArrayDeque<>();

  private boolean graph(String[] words) {
    for (String word : words) {
      for (char c : word.toCharArray()) {
        if (!map.containsKey(c)) {
          map.put(c, new ArrayList<Character>());
        }
      }
    }
    for (int i = 1; i < words.length; i++) {
      String w1 = words[i - 1];
      String w2= words[i];
      int j = 0;
      while (j < Math.min(w1.length(), w2.length())) {
        if (w1.charAt(j) != w2.charAt(j)) {
          map.get(w1.charAt(j)).add(w2.charAt(j));
          break;
        }
        j++;
      }
      if (j == w2.length() && j < w1.length()) {
        return false;
      }
    }
    return true;
  }

  private boolean dfs(char v) {
    onPath[v - 'a'] = true;
    for (char w : map.get(v)) {
      if (onPath[w - 'a']) {
        return false;
      }
      if (!marked[w - 'a']) {
        if (!dfs(w)) {
          return false;
        }
      }
    }
    onPath[v - 'a'] = false;
    marked[v - 'a'] = true;
    stack.push(v);
    return true;
  }

  public String alienOrder(String[] words) {
    if (!graph(words)) {
      return "";
    }
    for (char v : map.keySet()) {
      if (!marked[v - 'a']) {
        if (!dfs(v)) {
          return "";
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    return sb.toString();
  }
}

/**
 * performance: 4 ms < 90%, 37 MB < 100%
 * time complexity: 
 * space complexity:
 */

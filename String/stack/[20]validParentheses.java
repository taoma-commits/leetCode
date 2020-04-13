class Solution {
    public boolean isValid(String s) {
      if (s.length() % 2 == 1) {
        return false;
      }
      Map<Character, Character> map = new HashMap<>();
      map.put('}', '{');
      map.put(']', '[');
      map.put(')', '(');
      Deque<Character> stack = new ArrayDeque<>();
      for (char c : s.toCharArray()) {
        if (map.containsKey(c)) {
          if (stack.peek() != map.get(c)) {
            return false;
          } else {
            stack.pop();
          }
        } else {
          stack.push(c);
        }
      }
      return stack.isEmpty();
    }
}


/**
 * Performance: 2 ms < 89%, 37 MB < 5%
 * time complexity: worst O(n)
 * space complexity: worst O(n)
 */

/**
 * Runtime: 1 ms < 98.61%
 * Memory Usage: 37.9 MB < 5.06%
 */

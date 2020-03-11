class Solution {
    public String removeDuplicateLetters(String s) {
        int[] map = new int[26]; // hash numbers of occurances
        boolean[] status = new boolean[26]; // book taken letters
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int id = s.charAt(i) - 'a'; // use numbers to represent characters
            map[id]--;
            if (!status[id]) {
                while (!stk.isEmpty() && id < stk.peek() && map[stk.peek()] > 0) {
                    status[stk.pop()] = false;
                }
                stk.push(id);
                status[id] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int id : stk) {
            sb.append((char)('a' + id));
        }
        return sb.toString();
    }
}

/**
* performance: 4 ms < 86.47%, 38.4 MB < 5.16%
* notes: as iterating over the given string s,
      maintain the invariance that the StringBuilder
      is the smallest Lexicographical incomplete candidate.
*/

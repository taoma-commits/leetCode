/*
* Runtime: 2 ms, faster than 54.53% of Java online submissions for Valid Parentheses.
* Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Valid Parentheses.
* @dataStrucutre: stack 
*/

class Solution {
    // use HashMap class to build ST
    private HashMap<Character, Character> map = new HashMap<>();
    // trick: ST simplify code
    public boolean isValid(String s) {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>(); // Stack class
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.map.containsKey(c)) {
                char top = stack.empty()? '#' : stack.pop(); // boolean ? case1 : case2
                if (top != map.get(c)) return false;
            }
            else stack.push(c);
        }
        return stack.isEmpty(); // may have extra parantheses
    }
}

System.out.println(Solution.isValid( '{[]]()]}' ));

/*
time complexity: worst O(n)
space complexity: worst O(n)
*/

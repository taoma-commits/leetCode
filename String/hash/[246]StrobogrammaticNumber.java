class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('0', '0');
        map.put('1', '1');
        int n = num.length();
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            if (!map.containsKey(c) || num.charAt(n - 1 - i) != map.get(c)) {
                return false;
            }
        }
        return true;
    }
}
/**
* performance: 0 ms < 100%, 37 MB < 6%;
*/

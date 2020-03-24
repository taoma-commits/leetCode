class Solution {
    public boolean canPermutePalindrome(String s) {
        int n = s.length();
        if (n < 2) return true;
        char[] arr = s.toCharArray();
        int[] map = new int[128];
        for (char c : arr) {
            map[c]++;
        }
        int countOdds = - (n % 2);
        for (int i = 0; i < 128; i++) {
            countOdds += map[i] % 2;
            if (countOdds > 0) {
                return false;
            }
        }
        return true;
    }
}

/**
 * performance: 0 ms < 100%, 37 MB < 7% 
 */

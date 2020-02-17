// my initial code
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null) return 0;
        int n = s.length();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(n - i) != ' ') {
                count++;
            } else {
                if (count != 0) break;
            }
        }
        return count;
    }
}

/**
* performance: 0ms < 100%, 41.5 < 5%
*/

// better code
class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int count = 0;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }
        return count;
    }
}

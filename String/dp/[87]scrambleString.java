// recursion with pruning
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        int[] hash = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            hash[s1.charAt(i) - 'a']++;
            hash[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) {
                return false;
            }
        }
        int n = s1.length();
        for (int i = 1; i < n; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, n - i))) {
                return true;
            }
        }
        return false;
    }
}

/**
* performance: 2 ms < 97%, 39 MB < 24%
* notes:
*/

// recursion with cache and pruning

/**
* performance: 
*/


// dp with pruning
class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (n != s2.length()) {
            return false;
        }
        if (n == 0) {
            return true;
        }

        int[] hash = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            hash[s1.charAt(i) - 'a']++;
            hash[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) {
                return false;
            }
        }

        boolean[][][] dp = new boolean[n][n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int l = 2; l < n + 1; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                for (int j = 0; j < n - l + 1; j++) {
                    for (int k = 1; k < l; k++) {
                        if (dp[i][j][k] && dp[i + k][j + k][l - k]) {
                            dp[i][j][l] = true;
                            break;
                        }
                        if (dp[i][j + l - k][k] && dp[i + k][j][l - k]) {
                            dp[i][j][l] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }
}

/**
* performance: 8 ms < 38%, 39 MB < 24%
* notes:
*
*/

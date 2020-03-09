class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if (sl > tl) {
            return isOneEditDistance(t, s);
        }
        if (tl - sl > 1) {
            return false;
        }
        for (int i = 0; i < sl; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (sl == tl) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        return (sl + 1 == tl);
    }
}

/**
* performance: 1 ms < 100%, 38 MB < 11%
* notes: becareful with corner cases like
          - "", ""
          - "", "a"
          - "aaa", "aaaa"
*/

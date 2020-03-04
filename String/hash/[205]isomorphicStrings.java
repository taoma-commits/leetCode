class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] st = new int[256];
        int[] ts = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (st[s.charAt(i)] != ts[t.charAt(i)]) {
                return false;
            }
            st[s.charAt(i)] = i + 1; // note 2
            ts[t.charAt(i)] = i + 1;
        }
        return true;
    }
}

/**
* performance: 11 ms < 60%, 38 MB< 5%
* notes: 1. hash characters by an int array of length 256.
          The extended ASCII codes contains 256
          different characeters.
        2. the way to build a bijection map between two sets of chars.
* tag: hash 
*/

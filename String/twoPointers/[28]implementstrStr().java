class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for(int j = 0; ; j++) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j == haystack.length()) {
                    return -1;
                }
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
        }
    }
}

/**
* performance: 4ms < 33%, 41 MB < 5%
* notes: 1. empty string has length 0! So if
            needle.isEmpty(), returns 0.
* tag: two pointers      
*/

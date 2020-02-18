class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int l = 0;
        int r = 0;
        while (r <= s.length) {
            if (r == s.length || s[r] == ' ') { // note 1
                reverse(s, l, r - 1);
                l = r + 1;
            }
            r++;
        }
    }

    private void reverse(char[] s, int l, int r) {
        while (l < r) {
            char temp = s[l];
            s[l++] = s[r];
            s[r--] = temp;
        }
    }
}

/**
* performance: 2 ms < 87%, 50 MB < 5%;
* notes: 1. the ```char``` is a primitive data type so compare by ```==```.
            the ```String``` is non-primitve.
* tag: two pointers
*/

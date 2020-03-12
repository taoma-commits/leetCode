class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append((char)((--n) % 26 + 'A'));
            n = (n - n % 26) / 26;
        }
        sb.reverse();
        return sb.toString();
    }
}

/**
* performance: 0 ms < 100%, 37 MB < 5%
* notes: caution!
* tag: Math 
*/

/*
Runtime: 9 ms, faster than 22.15% of Java online submissions for Bulls and Cows.
Memory Usage: 39.4 MB, less than 5.26% of Java online submissions for Bulls and Cows.
*/

// tag: array, hash table
// notes: use array as a hash table; trick convert char to a single digit int.


class Solution {
    public String getHint(String secret, String guess) {
        int a = 0, b = 0, len = secret.length();
        int[] A = new int[10];
        int[] B = new int[10];
        for (int i = 0; i < len; i++) {
            int x = secret.charAt(i) - '0'; // a trick converting char to single digit int.
            int y = guess.charAt(i) - '0';
            if (x == y) a++;
            A[x]++;
            B[y]++;
        }
        for (int i = 0; i < 10; i++) b += Math.min(A[i], B[i]);
        return a + "A" + (b - a) + "B";
    }
}

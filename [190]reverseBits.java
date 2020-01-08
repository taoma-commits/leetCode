/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse Bits.
Memory Usage: 35.5 MB, less than 7.32% of Java online submissions for Reverse Bits.
@bitsManipulate: >>, <<, >>=, <<=, &, |, ^
*/

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + (n & 1);
            n >>= 1;
        }
        return result;
    }
}

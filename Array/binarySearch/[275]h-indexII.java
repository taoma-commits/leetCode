/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for H-Index II.
Memory Usage: 45 MB, less than 83.33% of Java online submissions for H-Index II.
*/

class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int lo = 0, len = citations.length, hi = len - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (citations[mid] < len - mid) {
                lo = mid + 1;
            }
            else if (citations[mid] > len - mid) {
                hi = mid;
            }
            else return citations[mid];
        }
        if (citations[lo] >= len - lo) return len - lo;
        else return len - lo - 1;
    }
}

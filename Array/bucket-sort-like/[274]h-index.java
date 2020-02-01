/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for H-Index.
Memory Usage: 37.2 MB, less than 100.00% of Java online submissions for H-Index.
*/

// notes: bucket-sort-like; make sure you fully understand the problem!
// time complexity: O(n)
// alternate solution: sort and binary search, O(nlog(n))

class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length, sum = 0;
        int[] buckets = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (citations[i] >= len) buckets[0]++;
            else buckets[len - citations[i]]++;
        }
        int h = len;
        while (sum > h || sum + buckets[len - h] < h) {
            sum += buckets[len - h];
            h--;
        }
        return h;
    }
}

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

/**
* performance: 0 ms < 100%, 37MB < 100%.
* tag: bucket sort
* notes:
* companies: Google, Adobe.
*/

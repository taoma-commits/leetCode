class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;

        int[] buckets = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                buckets[0]++;
            } else {
                buckets[n - citations[i]]++;
            }
        }

        int h = n;
        int sum = 0;
        while (sum + buckets[n - h] < h) {
            sum += buckets[n - h];
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

class Solution {
    public static class pairComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]; // priority queue by default is minPQ
        }
    }
    public String rearrangeString(String s, int k) {
        if (k < 2 || s.length() == 0) {
            return s;
        }

        int len = s.length();
        int[] map = new int[26]; // map stores letters and the number of their appearances.
        for (int i = 0; i < len; i++) {
            map[s.charAt(i) - 'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new pairComparator());
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                pq.add(new int[]{i, map[i]});
            }
        }

        StringBuilder sb = new StringBuilder(len);
        while (!pq.isEmpty()) {
            List<int[]> cache = new ArrayList<>();
            int scope = Math.min(k, len);
            for (int i = 0; i < scope; i++) {
                if (pq.isEmpty()) {
                    return "";
                }
                len--;
                int[] max = pq.poll();
                sb.append((char) ('a' + max[0]));
                if (--max[1] > 0) {
                    cache.add(max);
                }
            }
            for (int[] p : cache) {
                pq.add(p);
            }
        }
        return sb.toString();
    }
}

/**
* performance: 18 ms < 79%, 41.9 MB < 14%
* notes: the problem needs further conditions on legal outputs. 
*/

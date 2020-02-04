class Solution {
    private long bucket(long num, long t) {
        long n = num < 0 ? (num + 1) / (t + 1) - 1 : num / (t + 1);
        return n;
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long b = bucket((long) nums[i], (long) t);
            if (map.containsKey(b)) return true; // note 4
            if (map.containsKey(b - 1) && Math.abs(map.get(b - 1)- nums[i]) <= t) return true;
            if (map.containsKey(b + 1) && Math.abs(map.get(b + 1) - nums[i]) <= t) return true;
            map.put(b, (long) nums[i]);
            if (i > k) map.remove(bucket((long) nums[i - k], (long) t));
        }
        return false;
    }
}

/*
* performance: 14 ms < 90%, 38.4 mb < 13%
* notes:
      1. If algorithm involves arithmetic operations of input integers,
        use long type to avoid overflow.
      2. Bucket-sort-like algorithm: implements buckets by a hash table (not array),
        use buckets to keep track of sliding window. Hash table easy search and insert.
      3. Java arithmetic operators / and %: for negative a/b, a / b = upperfloor(a/b)
         and a % b = a - (a / b) * b always.
      4. If two elements put in same bucket, the algorithm terminates.
* companies: Adobe, Apple.
*/

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer c = set.ceiling(nums[i]);
            if (c != null && (long) c - (long) nums[i] <= t) return true;
            Integer f = set.floor(nums[i]);
            if (f != null && (long) nums[i] - (long) f <= t) return true;
            set.add(nums[i]);
            if (i >= k) set.remove(nums[i - k]);
        }
        return false;
    }
}

/*
* performance 23 ms, 36.7 MB
* notes:
      1. another way to keep track of sliding window is BST. Easy search and insert.
        Easy floor and ceiling.
      2. cast to long type to avoid overflow.
*/

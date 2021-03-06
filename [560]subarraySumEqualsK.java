/*
Runtime: 13 ms, faster than 95.11% of Java online submissions for Subarray Sum Equals K.
Memory Usage: 48.1 MB, less than 5.43% of Java online submissions for Subarray Sum Equals K.
*/

/*
* hashMap
* update hashMap value: map.getOrDefault(sum, 0)
*/


public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

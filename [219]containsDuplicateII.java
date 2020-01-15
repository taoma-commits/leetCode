/*
Runtime: 8 ms, faster than 86.56% of Java online submissions for Contains Duplicate II.
Memory Usage: 41.8 MB, less than 94.74% of Java online submissions for Contains Duplicate II.
@hashMap
*/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            curr = nums[i];
            if (map.containsKey(curr)) {
                if (i - map.get(curr) <= k) return true;
            }
            map.put(curr, i);
        }
        return false;
    }
}
